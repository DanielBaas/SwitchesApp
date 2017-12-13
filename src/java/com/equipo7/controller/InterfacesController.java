package com.equipo7.controller;

import com.equipo7.model.DBConnection;
import com.equipo7.model.SwitchDao;
import com.equipo7.model.SwitchInterface;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class InterfacesController {
    
    private JdbcTemplate jdbcTemplate;
    
    public InterfacesController() {
        DBConnection connection = new DBConnection();
        this.jdbcTemplate = new JdbcTemplate((DataSource) connection.connect());
    }
    
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
