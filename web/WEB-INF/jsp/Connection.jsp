<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="org.jfree.data.general.*"%>
<%@page import="org.jfree.chart.*"%>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Connection</title>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/switches.htm" />">Switches</a></li>
                <li class="active">/Registrar Switch</li>
            </ol>
                
            <div class="panel panel-primary">
                <div class="panel-body">
                    <%
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection connectionM = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciscoswitches", "root", "");
                        Statement cmS = connectionM.createStatement();
                        Statement cmI = connectionM.createStatement();
                        String sqlSwitches = "SELECT * FROM switchcisco";
                        String sqlInterface = "SELECT * FROM switchinterface";
                        ResultSet resultSwitches  = cmS.executeQuery(sqlSwitches);
                        ResultSet resultInterfaces  = cmI.executeQuery(sqlInterface);
                    %>  
                </div>
            </div>
        </div>
    </body>
</html>
