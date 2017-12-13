package com.equipo7.controller;

import com.equipo7.model.DBConnection;
import com.equipo7.model.SwitchCisco;
import com.equipo7.model.SwitchDao;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteSwitchController {
    
    private JdbcTemplate jdbcTemplate;
    
    public DeleteSwitchController() {
        DBConnection connection = new DBConnection();
        this.jdbcTemplate = new JdbcTemplate(connection.connect());
    }
    
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
