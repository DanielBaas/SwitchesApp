package com.equipo7.controller;

import com.equipo7.model.SwitchCisco;
import com.equipo7.model.SwitchDao;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

public class EditSwitchController {
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        
        int switchid = Integer.parseInt(request.getParameter("id"));
        SwitchCisco switchCisco = this.selectSwitch(switchid);
        
        mav.setViewName("editSwitch");
        mav.addObject("switches", new SwitchCisco(
                switchid, 
                switchCisco.getUser(),
                switchCisco.getHost(),
                switchCisco.getPort(),
                switchCisco.getPass()));
        
        return mav;
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("clientes") SwitchCisco switchCisco,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
        ) throws ParseException 
    {   
        int switchId = Integer.parseInt(request.getParameter("id"));
        SwitchDao dao = new SwitchDao();
        
        switchCisco.setPk(switchId);
        dao.updateSwitch(switchCisco);
        
        return new ModelAndView("redirect:/switches.htm");
    }
    
    public SwitchCisco selectSwitch(int switchid) {
        SwitchCisco switchCisco = new SwitchCisco();
        SwitchDao dao = new SwitchDao();
        
        switchCisco = dao.findSwitchByID(switchid);
        
        return switchCisco;
    }
    
}
