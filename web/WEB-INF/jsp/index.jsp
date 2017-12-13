<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8">
        <title>Store App</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" /></script>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="container">
                    <div class="row" style="padding-top: 3%;" align="center">
                        <h1 align="center">Store App</h1>
                    </div>
                </div>

                <div class="container">
                    <div class="col" style="padding-top: 1%; padding-bottom: 1%; background-color: gainsboro" align="left" >
                        <a href="<c:url value="clientes.htm"/>" class="btn btn-success">Clientes</a>
                    </div>
                    
                    <div class="col" style="padding-top: 1%; padding-bottom: 1%" align="left">
                        <a href="<c:url value="empleados.htm"/>" class="btn btn-success">Empleados</a>
                    </div>
                    
                    <div class="col" style="padding-top: 1%; padding-bottom: 1%; background-color: gainsboro" align="left">
                        <a href="<c:url value="productos.htm"/>" class="btn btn-success">Productos</a>
                    </div>
                    
                    <div class="col" style="padding-top: 1%; padding-bottom: 1%;" align="left">
                        <a href="<c:url value="proveedores.htm"/>" class="btn btn-success">Proveedores</a>
                    </div>
                    
                    <div class="col" style="padding-top: 1%; padding-bottom: 1%; background-color: gainsboro" align="left">
                        <a href="<c:url value="productosProveedores.htm"/>" class="btn btn-success">Productos-Proveedores</a>
                    </div>
                </div>
            </div>         
        </div>
    </body>
</html>
