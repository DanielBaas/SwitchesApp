import java.util.ArrayList;
import java.util.List;

public class Reports {

    private List<SwitchCisco> switches;

    public Reports() {
        switches = new ArrayList<SwitchCisco>();
    }

    public Reports(List<SwitchCisco> switches) {
        this.switches = switches;
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

        for (int i = 0; i < switches.size(); i++) {
            request.switchCommand(command, switchFile, switches.get(i));
            switches.get(i).setInterface(switchFile);
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
            if (switches.get(i).getDispoble()) {
                availableSwitches++;
            }
        }

        return 0.0;
    }

}
