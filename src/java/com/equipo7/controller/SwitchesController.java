package com.equipo7.controller;

import com.equipo7.model.DBConnection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class SwitchesController {
    
    private JdbcTemplate jdbcTemplate;
    
    public SwitchesController() {
        DBConnection connection = new DBConnection();
        this.jdbcTemplate = new JdbcTemplate(connection.connect());
    }
    
    @RequestMapping("switches.htm")
    public ModelAndView switches() {
        ModelAndView mav = new ModelAndView();
        String sql = "select * from SwitchCisco";
        List switches = this.jdbcTemplate.queryForList(sql);
        mav.addObject("switches", switches);
        mav.setViewName("switches");

        return mav;
    }
    
}
