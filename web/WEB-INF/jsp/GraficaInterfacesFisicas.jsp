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
        <title>GraficaInterfacesFisicas</title>
    </head>
    <body>
        <%
            try{
                DefaultPieDataset data = new DefaultPieDataset();
                int cantUp, cantDown, cantUnknown;
                cantUp = 0;
                cantDown = 0;
                cantUnknown = 0;
                ArrayList<String> interfaz = new ArrayList<String>();
                ArrayList<String> estado = new ArrayList<String>();
                
                        
                while(resultInterfaces.next()){
                    interfaz.add(resultInterfaces.getString("interfaceType"));
                    estado.add(resultInterfaces.getString("status"));
                }
                System.out.println("numInterfaces" +interfaz.size());
                for(int i=0; i<interfaz.size();i++){
                    if(interfaz.get(i).contains("FastEthernet")){
                        if(i< estado.size()-1){
                            if(estado.get(i).contains("up"))
                            cantUp++;
                        else if(estado.get(i).contains("down"))
                            cantDown++;
                        else if((estado.get(i).compareTo(null)) ==0)
                            cantUnknown++;
                        }
                        
                        
                    }
                        
                }
                data.setValue("up: \n" + cantUp, cantUp);
                data.setValue("down: \n " + cantDown, cantDown);
                data.setValue("unknown: \n " + cantUnknown, cantUnknown);
                
                JFreeChart grafico = ChartFactory.createPieChart("Porcentaje de Interfaces Físicas",  data, true,true,true);
                response.setContentType("image/JPEG");
                OutputStream salida = response.getOutputStream();
                
                ChartUtilities.writeChartAsJPEG(salida, grafico, 600, 600);
            }catch (Exception ex){
               out.print(ex); 
            }
        %>
    </body>
</html>
