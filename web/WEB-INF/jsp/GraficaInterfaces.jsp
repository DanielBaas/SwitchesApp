<%-- 
    Document   : GraficaPastel
    Created on : 15/12/2017, 04:51:15 AM
    Author     : ARMC3PO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file= "Connection.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GraficaInterfaces</title>
    </head>
    <body>
        <%
            try{
                DefaultPieDataset data = new DefaultPieDataset();
                int cantVirtual, cantFisicas;
                cantVirtual = 0;
                cantFisicas = 0;
                ArrayList<String> interfaz = new ArrayList<String>();
                        
                while(resultInterfaces.next()){
                    interfaz.add(resultInterfaces.getString("interfaceType"));
                    
                }
                if(interfaz.size() > 0){
                for(int i=0; i<interfaz.size();i++){
                    if(interfaz.get(i).contains("Vlan"))
                        cantVirtual++;
                    else if (interfaz.get(i).contains("FastEthernet"))
                        cantFisicas++;
                }
                data.setValue("Interfaces Virtuales: \n" + cantVirtual, cantVirtual);
                data.setValue("Interfaces Físicas: \n " + cantFisicas, cantFisicas);
                JFreeChart grafico = ChartFactory.createPieChart("Porcentaje de Interfaces",  data, true,true,true);
                response.setContentType("image/JPEG");
                OutputStream salida = response.getOutputStream();
                ChartUtilities.writeChartAsJPEG(salida, grafico, 600, 600);
                
            }catch (Exception ex){
               out.print(ex); 
            }
        %>
    </body>
</html>
