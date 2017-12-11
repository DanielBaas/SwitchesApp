import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SwitchCisco s1 = new SwitchCisco("admin", "192.168.69.3", 22, "cisco");
        Reports reports = new Reports();

        //Simula el registro de un nuevo switch
        reports.addNewSwitch(s1);

        //Ejecuta el comando para recuperar la versión y software del switch
        reports.showVersion();

        //Ejecuta el comando para recuperar la información de las interfaces del switch
        reports.showInterfaceBrief();

        //Ejecutan el comando para averiguar qué switches están disponibles. Aún no implementado
        reports.getSwitchesAvailability();
    }


}
