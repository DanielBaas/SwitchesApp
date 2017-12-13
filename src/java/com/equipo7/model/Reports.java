package com.equipo7.model;

import com.equipo7.model.SwitchCisco;
import com.equipo7.model.SwitchDao;
import com.equipo7.model.SwitchInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Reports {

    private List<SwitchCisco> switches;
    
    public Reports() {
        this.switches = new ArrayList<SwitchCisco>();
    }

    private List<SwitchInterface> setInterface(String switchFile) {
        String linea = "";
        String switchData[];
        List<SwitchInterface> interfaces = new ArrayList<SwitchInterface>();
        
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(switchFile);
            br = new BufferedReader(fr);

            //Salta la primera línea en blanco y la línea de encabezado de datos.
            br.readLine();
            br.readLine();

            while ((linea = br.readLine()) != null) {
                switchData = linea.split("\\s+");

                SwitchInterface switchInterface = new SwitchInterface();

                switchInterface.setInterfaceData(switchData);

                interfaces.add(switchInterface);
            }
        } catch (IOException e) {
            System.out.println("Error en el formato del archivo " + switchFile);
            System.out.println("el archivo esta vacio o no tiene informacion acerca de las interfaces.");
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return interfaces;
    }

    private SwitchCisco showVersion(SwitchCisco switchCisco) {
        final String command = "show version";
        final String switchFile = "show-version.txt";
        final SSHRequest request =  new SSHRequest();
        final SwitchCisco updatedSwitch = switchCisco;
        
        request.switchCommand(command, switchFile, updatedSwitch);
        updatedSwitch.setSoftwareAndVersion(switchFile);
        
        return updatedSwitch;
    }

    private List<SwitchInterface> showInterfaceBrief(SwitchCisco switchCisco) {
        final String command = "show ip interface brief";
        final String switchFile = "show-interface-brief.txt";
        final SSHRequest request = new SSHRequest();
        List<SwitchInterface> interfaces = new ArrayList<SwitchInterface>();
        
        request.switchCommand(command, switchFile, switchCisco);
        interfaces = setInterface(switchFile);
        
        return interfaces;
    }
    
    private boolean getSwitchAvailability(String ip) {
        final String switchFile = "ping.txt";
        final SSHRequest request = new SSHRequest();
        boolean available = true;
            
        request.pingCommand(ip, switchFile);
        
        return available;
    }
    
    public void addNewSwitch(SwitchCisco switchCisco) {
        this.switches.add(switchCisco);
    }
    
    public void requestSwitchesInfo() {
        int numberOfSwitches = switches.size();
        SwitchDao dao = new SwitchDao();
  
        for (int i = 0; i < numberOfSwitches; i++) {
            SwitchCisco sw = switches.get(i);
            List<SwitchInterface> interfaces = new ArrayList<SwitchInterface>();
            
            switches.set(i, showVersion(sw));
            
            sw = switches.get(i);
            
            dao.insertSwitch(sw);
            
            interfaces = showInterfaceBrief(sw);
            
            int switchId = dao.findSwitchByIP(sw.getHost()).getPk();
            
            for (int j = 0; i < interfaces.size(); j++) {
                interfaces.get(j).setSwitchCisco(switchId);
            }
            
            switches.get(i).setAvailability(getSwitchAvailability(sw.getHost()));
        }  
    }

}
