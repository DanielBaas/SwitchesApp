package com.equipo7.controller;

import com.equipo7.model.Reports;
import com.equipo7.model.SwitchCisco;
import com.equipo7.model.SwitchDao;
import com.equipo7.model.SwitchInterface;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("addSwitch.htm")
public class AddSwitchController {
    
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("addSwitch");
        mav.addObject("switches", new SwitchCisco());
        
        return mav;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("switches") SwitchCisco switchCisco,
            BindingResult result,
            SessionStatus status
        ) throws ParseException 
    {   
        Reports report = new Reports();
        List<SwitchInterface> interfaces = new ArrayList<SwitchInterface>();
        SwitchDao dao = new SwitchDao();
        
        switchCisco = report.requestSwitchInfo(switchCisco);
        dao.insertSwitch(switchCisco);
        
        interfaces = report.requestSwitchInterfacesInfo(switchCisco);
        
        for (SwitchInterface si : interfaces) {
            dao.insertInterface(si);
        }
        
        return new ModelAndView("redirect:/switches.htm");
    }
    
}
