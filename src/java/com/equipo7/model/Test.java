package com.equipo7.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SwitchCisco switchCisco = new SwitchCisco("admin", "192.168.69.3", 22, "cisco");
        Reports report = new Reports();
        List<SwitchInterface> interfaces = new ArrayList<SwitchInterface>();
        SwitchDao dao = new SwitchDao();
        
        switchCisco = report.requestSwitchInfo(switchCisco);
        dao.insertSwitch(switchCisco);
        
        interfaces = report.requestSwitchInterfacesInfo(switchCisco);
        
        for (SwitchInterface si : interfaces) {
            dao.insertInterface(si);
        }
    }
}
