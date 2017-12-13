package com.equipo7.model;

public class SwitchInterface {

    private int pk;
    private String interfaceType;
    private String ip;
    private String okStatus;
    private String method;
    private String status;
    private String protocol;
    private int switchCisco;

    public SwitchInterface() {
    }

    public void setInterfaceData(String[] switchData) {
        final int INTERFACE = 0;
        final int IP = 1;
        final int OK = 2;
        final int METHOD = 3;
        final int STATUS = 4;
        final int PROTOCOL = 5;

        int numberOfColums = switchData.length;

        switch (numberOfColums) {
            case 1:
                this.interfaceType = switchData[INTERFACE];
                this.ip = "";
                this.okStatus = "";
                this.method = "";
                this.status = "";
                this.protocol = "";
                break;
            case 2:
                this.interfaceType = switchData[INTERFACE];
                this.ip = switchData[IP];
                this.okStatus = "";
                this.method = "";
                this.status = "";
                this.protocol = "";
                break;
            case 3:
                this.interfaceType = switchData[INTERFACE];
                this.ip = switchData[IP];
                this.okStatus = switchData[OK];
                this.method = "";
                this.status = "";
                this.protocol = "";
                break;
            case 4:
                this.interfaceType = switchData[INTERFACE];
                this.ip = switchData[IP];
                this.okStatus = switchData[OK];
                this.method = switchData[METHOD];
                this.status = "";
                this.protocol = "";
                break;
            case 5:
                this.interfaceType = switchData[INTERFACE];
                this.ip = switchData[IP];
                this.okStatus = switchData[OK];
                this.method = switchData[METHOD];
                this.status = switchData[STATUS];
                this.protocol = "";
                break;
            case 6:
                this.interfaceType = switchData[INTERFACE];
                this.ip = switchData[IP];
                this.okStatus = switchData[OK];
                this.method = switchData[METHOD];
                this.status = switchData[STATUS];
                this.protocol = switchData[PROTOCOL];
                break;
            case 7:
                this.interfaceType = switchData[INTERFACE];
                this.ip = switchData[IP];
                this.okStatus = switchData[OK];
                this.method = switchData[METHOD];
                this.status = switchData[STATUS] + " " + switchData[STATUS+1];
                this.protocol = switchData[PROTOCOL+1];
                break;
        }
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOkStatus() {
        return okStatus;
    }

    public void setOkStatus(String okStatus) {
        this.okStatus = okStatus;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getSwitchCisco() {
        return switchCisco;
    }

    public void setSwitchCisco(int switchCisco) {
        this.switchCisco = switchCisco;
    }

}
