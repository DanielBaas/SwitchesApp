package com.equipo7.model;

public class Test {
    public static void main(String[] args) {
        SwitchCisco s1 = new SwitchCisco("admin", "192.168.69.3", 22, "cisco");
        Reports report = new Reports();
        
        report.addNewSwitch(s1);
        report.requestSwitchesInfo();
    }
}
