<%-- 
    Document   : crear
    Created on : 20/08/2016, 05:34:58 PM
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
               
            });
           
        </script>
        <title>Nueva Historia</title>
    </head>
    <body>
        <br /> <br /> <br />
        <div class="container">
            <h1>Registro de una Nueva Historia </h1>
            <form:form method="POST" action="${pageContext.request.contextPath}/historia/crearHistoria.htm" commandName="historia" class="form-horizontal">
                <hr/>
                 <div class="form-group">
                    <label class="col-lg-2 control-label">Veh&iacute;culo:</label>
                    <div class="col-lg-6">
                        <form:select cssClass="form-control" path="idLugar">
                            <form:option value="0" label="-- Seleccione --"/>
                            <form:options items="${ListaLugares}" itemLabel="nombreLugar" itemValue="idLugar" />
                        </form:select>                        
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Nombre: </label>
                    <div class="col-lg-6">
                        <form:input class="form-control" path="nombreHistoria" placeholder="Ingrese el Nombre" />
                       
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-2 control-label">Descripcion: </label>
                    <div class="col-lg-6">
                        <form:textarea class="form-control" path="descripcionHistoria" placeholder="Ingrese el Apellido" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="txtsalario" class="col-lg-2 control-label">Fecha de Historia: </label>
                    <div class="col-lg-6">
                        <form:input id="txtFecha" class="form-control" path="fechaHistoria" placeholder="Ingrese Salario" />
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
