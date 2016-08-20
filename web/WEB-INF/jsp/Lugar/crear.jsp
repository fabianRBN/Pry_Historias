<%-- 
    Document   : crear
    Created on : 20/08/2016, 05:35:27 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../template.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#txtFecha").datepicker();
                verInsumos();
            });
        </script>
        <title>Nuevo Lugar</title>
    </head>
    <body>
        <br /> <br /> <br />
        <div class="container">
            <h1>Registro de un nuevo Lugar</h1>
            <form:form method="POST" action="${pageContext.request.contextPath}/lugar/crear.htm" commandName="lugar" class="form-horizontal">
                <hr/>

                <div class="form-group">
                    <label class="col-lg-2 control-label">Nombre: </label>
                    <div class="col-lg-6">
                        <form:input class="form-control" path="nombreLugar" placeholder="Ingrese el Nombre" />
                       
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-2 control-label">Descripcion: </label>
                    <div class="col-lg-6">
                        <form:input class="form-control" path="descripcionLugar" placeholder="Ingrese el Apellido" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="txtsalario" class="col-lg-2 control-label">Fecha de Fundacion: </label>
                    <div class="col-lg-6">
                        <form:input id="txtFecha" class="form-control" path="fechaLugar" placeholder="Ingrese Salario" />
                    </div>
                </div>
                    
                
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="submit" value="Guardar" class="btn btn-primary" />
                        <a href="${pageContext.request.contextPath}/lugar.htm" class="btn btn-danger">Cancelar</a>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>
