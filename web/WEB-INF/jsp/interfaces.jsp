<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Interfaces</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" /></script>
    </head>
    
    <body>
        <div class="container">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/switches.htm" />">Home</a></li>
                    <li>/Interfaz</li>
                </ol>
                
                <div class="container">
                    <div class="row" style="padding-top: 3%;" align="center">
                        <h1 align="center">Interfaces del switch</h1>
                    </div>
                </div>
                
                <div class="container">
                    <div class="row" style="padding-top: 3%; padding-bottom: 3%" align="center">
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Tipo de interfaz</th>
                                    <th>IP</th>
                                    <th>Ok Status</th>
                                    <th>Método</th>
                                    <th>Estado</th>
                                    <th>Protocolo</th>                                    
                                </tr>
                            </thead>
                            <tbody>    
                                <c:forEach var="interfaz" items="${interfaces}">
                                    <tr>
                                        <td><c:out value="${interfaz.interfaceType}" /></td>
                                        <td><c:out value="${interfaz.ip}" /></td>
                                        <td><c:out value="${interfaz.okStatus}" /></td>
                                        <td><c:out value="${interfaz.method}" /></td>
                                        <td><c:out value="${interfaz.status}" /></td>
                                        <td><c:out value="${interfaz.protocol}" /></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
