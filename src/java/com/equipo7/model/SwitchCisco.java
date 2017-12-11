import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SwitchCisco {

    private int pk;
    private String user;
    private String host;
    private Integer port;
    private String pass;
    private String software;
    private String version;
    private List<SwitchInterface> switchInterfaces;
    private boolean disponible;

    public SwitchCisco() {}

    public SwitchCisco(String user, String host, int port, String pass) {
        this.pk = -1;
        this.user = user;
        this.host = host;
        this.port = port;
        this.pass = pass;
        this.software = "";
        this.version = "";
        this.switchInterfaces = new ArrayList<SwitchInterface>();
        this.disponible = true;
    }

    public void setSoftwareAndVersion(String switchFile) {
        String linea = "";
        String switchData[];
        final int SOFTWARE = 1;
        final int VERSION = 2;

        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(switchFile);
            br = new BufferedReader(fr);

            linea = br.readLine();
            switchData = linea.split(", ");

            if (switchData.length >= 2) {
                this.software = switchData[SOFTWARE];
                this.version = switchData[VERSION];
            }
        } catch (IOException e) {
            System.out.println("Error en el formato del archivo " + switchFile);
            System.out.println("el archivo esta vacio o no tiene informacion acerca del software y version.");
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

    public void setInterface(String switchFile) {
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

    public void setAvailabity(String switchFile) {

    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getSoftware() {
        return software;
    }

    public String getVersion() {
        return version;
    }

    public void setDisponible(boolean disponbile) {
        this.disponible = disponbile;
    }

    public boolean getDispoble() {
        return disponible;
    }
}
