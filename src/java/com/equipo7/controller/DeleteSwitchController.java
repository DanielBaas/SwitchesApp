package com.equipo7.controller;

import com.equipo7.model.SwitchCisco;
import com.equipo7.model.SwitchDao;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteSwitchController {
    
    @RequestMapping("deleteSwitch.htm")
    public ModelAndView home(HttpServletRequest request) {
        int switchid = Integer.parseInt(request.getParameter("id"));
        SwitchCisco switchCisco = new SwitchCisco();
        SwitchDao dao = new SwitchDao();
        
        switchCisco = dao.findSwitchByID(switchid);
        dao.deleteSwitch(switchCisco);
        
        return new ModelAndView("redirect:/switches.htm");
    }
    
}
