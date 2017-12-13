package com.equipo7.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SwitchCisco {

    private int pk;
    private String user;
    private String host;
    private int port;
    private String pass;
    private String software;
    private String version;
    private boolean isAvailable;
    
    public SwitchCisco() {
    }

    public SwitchCisco(int pk, String user, String host, int port, String pass) {
        this.pk = pk;
        this.user = user;
        this.host = host;
        this.port = port;
        this.pass = pass;
        this.software = "";
        this.version = "";
        this.isAvailable = true;
    }
    
    public SwitchCisco(String user, String host, int port, String pass) {
        this.user = user;
        this.host = host;
        this.port = port;
        this.pass = pass;
        this.software = "";
        this.version = "";
        this.isAvailable = true;
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

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
