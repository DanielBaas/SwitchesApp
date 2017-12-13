package com.equipo7.controller;

import com.equipo7.model.DBConnection;
import com.equipo7.model.SwitchCisco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

public class EditSwitchController {
    
    private JdbcTemplate jdbcTemplate;
    
    public EditSwitchController() {
        DBConnection connection = new DBConnection();
        this.jdbcTemplate = new JdbcTemplate(connection.connect());
    }
    
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
        
        this.jdbcTemplate.update("update SwitchCisco set "
                + "user=?, "
                + "host=?, "
                + "port=?, "
                + "pass=? "
                + "where "
                + "pk=? ",
                switchCisco.getUser(),
                switchCisco.getHost(),
                switchCisco.getPort(),
                switchCisco.getPass(),
                switchId);
        
        return new ModelAndView("redirect:/switches.htm");
    }
    
    public SwitchCisco selectSwitch(int switchid) {
        final SwitchCisco switchCisco = new SwitchCisco();
        String query = "select * from SwitchCisco where pk='" + switchid + "'";
        
        return (SwitchCisco) this.jdbcTemplate.query(query, new ResultSetExtractor<SwitchCisco>() {
            @Override
            public SwitchCisco extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    switchCisco.setUser(rs.getString("user"));
                    switchCisco.setHost(rs.getString("host"));
                    switchCisco.setPort(Integer.valueOf(rs.getString("port")));
                    switchCisco.setPass(rs.getString("pass"));
                }
                
                return switchCisco;
            }          
        });
    }
}
