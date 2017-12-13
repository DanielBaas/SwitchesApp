import com.equipo7.model.SwitchCisco;
import com.equipo7.model.SwitchInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reports {

    private List<SwitchCisco> switches;
    private List<SwitchInterface> switchInterfaces;
    
    public Reports() {
        switches = new ArrayList<SwitchCisco>();
        this.switchInterfaces = new ArrayList<SwitchInterface>();
    }

    public Reports(List<SwitchCisco> switches) {
        this.switches = switches;
        this.switchInterfaces = new ArrayList<SwitchInterface>();
    }

    private void setInterface(String switchFile) {
        String linea = "";
        String switchData[];

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

                switchInterfaces.add(switchInterface);
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
    }
    
    public void addNewSwitch(SwitchCisco switchCisco) {
        this.switches.add(switchCisco);
    }

    public void showVersion() {
        final String command = "show version";
        final String switchFile = "show-version.txt";
        final SSHRequest request =  new SSHRequest();

        for (int i = 0; i < switches.size(); i++) {
            request.switchCommand(command, switchFile, switches.get(i));
            switches.get(i).setSoftwareAndVersion(switchFile);
        }
    }

    public void showInterfaceBrief() {
        final String command = "show ip interface brief";
        final String switchFile = "show-interface-brief.txt";
        final SSHRequest request = new SSHRequest();
        List<SwitchInterface> interfaces = new ArrayList<SwitchInterface>();
        
        for (int i = 0; i < switches.size(); i++) {
            request.switchCommand(command, switchFile, switches.get(i));
            setInterface(switchFile);
        }
    }

    public void getSwitchesAvailability() {
        final String switchFile = "ping.txt";
        final SSHRequest request = new SSHRequest();

        for (int i = 0; i < switches.size(); i++) {
            String switchIp = switches.get(i).getHost();
            request.pingCommand(switchIp, switchFile);
            switches.get(i).setAvailabity(switchFile);
        }
    }

    //Aún no implementado
    public double getAvailableSwitchesPercentage() {
        int numberOfSwitches = switches.size();
        int availableSwitches = 0;

        for (int i = 0; i < numberOfSwitches; i++) {
            if (switches.get(i).isAvailable()) {
                availableSwitches++;
            }
        }

        return 0.0;
    }

}
