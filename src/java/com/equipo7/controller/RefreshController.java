package com.equipo7.controller;

import com.equipo7.model.Reports;
import com.equipo7.model.SwitchCisco;
import com.equipo7.model.SwitchDao;
import com.equipo7.model.SwitchInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class RefreshController {
    
    @RequestMapping("refresh.htm")
    public ModelAndView home() {
        Reports report = new Reports();
        SwitchDao dao = new SwitchDao();
        List<SwitchCisco> switches = new ArrayList<SwitchCisco>();
        
        switches = dao.getAllSwitches();
        
        for (SwitchCisco switchCisco : switches) {
            switchCisco = report.requestSwitchInfo(switchCisco);
            dao.updateSwitch(switchCisco);
            
            List<SwitchInterface> interfaces = report.requestSwitchInterfacesInfo(switchCisco);
            
            for (SwitchInterface si : interfaces) {
               dao.updateInterface(si);
            }
        }
        
        return new ModelAndView("redirect:/switches.htm");
    }
    
}
