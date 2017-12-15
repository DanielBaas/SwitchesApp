package com.equipo7.controller;

import com.equipo7.model.SwitchDao;
import com.equipo7.model.SwitchInterface;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class InterfacesController {
    
    @RequestMapping("interfaces.htm")
    public ModelAndView interfaces(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int switchId = Integer.parseInt(request.getParameter("id"));
        SwitchDao dao = new SwitchDao();
        
        List<SwitchInterface> interfaces = dao.findInterfacesBySwitchID(switchId);
        
        mav.setViewName("interfaces");
        mav.addObject("interfaces", interfaces);
  
        return mav;
    }
    
}
