<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Editar switches</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" /></script>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/switches.htm" />">Switches</a></li>
                <li class="active">/Editar Switch</li>
            </ol>
                
            <div class="panel panel-primary">
                <div class="panel-body">
                    <form:form method="post" commandName="switches">
                        <h1>Editar datos del switch:</h1>
                        
                        <form:errors path="*" element="div" cssClass="alert alert-danger" />
                        
                        <p>
                            <form:label path="user">User:</form:label>
                            <form:input path="user" cssClass="form-control" />
                        </p>
                        
                        <p>
                            <form:label path="host">IP:</form:label>
                            <form:input path="host" cssClass="form-control" />
                        </p>
                        
                        <p>
                            <form:label path="port">Puerto</form:label>
                            <form:input path="port" cssClass="form-control" />
                        </p>
                        
                        <p>
                            <form:label path="pass">Password</form:label>
                            <form:input path="pass" cssClass="form-control" />
                        </p>
                        
                        <hr />
                        
                        <input type="submit" value="Guardar" class="btn btn-success" />
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
