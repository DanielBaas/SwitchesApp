package com.equipo7.controller;

import com.equipo7.model.DBConnection;
import com.equipo7.model.SwitchCisco;
import java.text.ParseException;
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
    
    public AddSwitchController() {
        DBConnection connection = new DBConnection();
        this.jdbcTemplate = new JdbcTemplate(connection.connect());
    }
    
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
        this.jdbcTemplate.update("insert into SwitchCisco (user, host, port, pass) values(?, ?, ?, ?)",
                switchCisco.getUser(),
                switchCisco.getHost(),
                switchCisco.getPort(),
                switchCisco.getPass());
        
        return new ModelAndView("redirect:/switches.htm");
    }
    
}
