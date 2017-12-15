package com.equipo7.controller;

import com.equipo7.model.SwitchCisco;
import com.equipo7.model.SwitchDao;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class SwitchesController {
    
    @RequestMapping("switches.htm")
    public ModelAndView switches() {
        ModelAndView mav = new ModelAndView();
        SwitchDao dao = new SwitchDao();
        List<SwitchCisco> switches = dao.getAllSwitches();
        
        mav.addObject("switches", switches);
        mav.setViewName("switches");

        return mav;
    }
    
}
