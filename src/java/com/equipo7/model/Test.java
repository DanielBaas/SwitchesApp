package com.equipo7.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SwitchCisco switchCisco = new SwitchCisco("admin", "192.168.69.3", 22, "cisco");
        SwitchCisco sw2 = new SwitchCisco("admin", "192.168.69.4", 22, "cisco");
        Reports report = new Reports();
        List<SwitchInterface> interfaces = new ArrayList<SwitchInterface>();
        List<SwitchInterface> interfacesSW2 = new ArrayList<SwitchInterface>();
        SwitchDao dao = new SwitchDao();

        switchCisco = report.requestSwitchInfo(switchCisco);
        sw2 = report.requestSwitchInfo(sw2);
        
        dao.insertSwitch(switchCisco);
        dao.insertSwitch(sw2);

        interfaces = report.requestSwitchInterfacesInfo(switchCisco);

        for (SwitchInterface si : interfaces) {
            dao.insertInterface(si);
        }

        interfacesSW2 = report.requestSwitchInterfacesInfo(sw2);

        for (SwitchInterface si : interfacesSW2) {
            dao.insertInterface(si);
        }

    }
}