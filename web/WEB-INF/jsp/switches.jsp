<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Switches</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" /></script>
    </head>
    
    <body>
        <div class="container">
            <div class="row">
                <ol class="breadcrumb">
                    <li class="active">Switches</li>
                </ol>
                
                <div class="container">
                    <div class="row" style="padding-top: 3%;" align="center">
                        <h1 align="center">Administración de switches</h1>
                    </div>
                </div>
                
                <div class="container">
                    <div class="row" style="padding-top: 3%;" align="left">
                        <a href="<c:url value="addSwitch.htm"/>" class="btn btn-success">Agregar</a>
                    </div>
                </div>
                
                <div class="container">
                    <div class="row" style="padding-top: 3%; padding-bottom: 3%" align="center">
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Usuario</th>
                                    <th>IP</th>
                                    <th>Puerto</th>
                                    <th>Software</th>
                                    <th>Versión</th>
                                    <th>Disponibilidad</th>
                                </tr>
                            </thead>
                            <tbody>    
                                <c:forEach items="${switches}" var="switch">
                                    <tr>
                                        <td><c:out value="${switch.user}" /></td>
                                        <td><c:out value="${switch.host}" /></td>
                                        <td><c:out value="${switch.port}" /></td>
                                        <td><c:out value="${switch.software}" /></td>
                                        <td><c:out value="${switch.version}" /></td>
                                        <td><c:out value="${switch.isAvailable}" /></td>
                                        <td>
                                            <a href="<c:url value="editSwitch.htm?id=${switch.pk}"/>" class="btn btn-warning">Editar</a>
                                            <a href="<c:url value="deleteSwitch.htm?id=${switch.pk}"/>" class="btn btn-danger">Eliminar</a>
                                            <a href="<c:url value="switchIntarfaces.htm?id=${switch.pk}"/>" class="btn btn-danger">Interfaces</a>
                                        </td>
                                        <td></td>
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
