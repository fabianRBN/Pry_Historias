<%-- 
    Document   : editar
    Created on : 20/08/2016, 06:22:58 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <title>Editar Lugar</title>
    </head>
    <body>
        <br /> <br /> <br />
        <div class="container">
            <div class="row">
                <br />
                <div class="col-md-8"><h1>Editar Lugar</h1></div>
               
            </div>

            <form:form method="POST" action="${pageContext.request.contextPath}/lugar/editar.htm" commandName="lugar" class="form-horizontal">
                <hr/>

                <div class="form-group">
                    <div class="col-lg-6">
                        <form:input type="hidden" class="form-control" path="idLugar" value="${resultado.idLugar}" />
                    </div>
                </div>

                
                <div class="form-group">
                    <label for="txtnombre" class="col-lg-2 control-label">Nombre:</label>
                    <div class="col-lg-6">
                        <form:input class="form-control" path="nombreLugar" placeholder="Ingrese el Nombre" value="${resultado.nombreLugar}" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="txtapellido" class="col-lg-2 control-label">Descripcion:</label>
                    <div class="col-lg-6">
                        <form:input class="form-control" path="descripcionLugar" placeholder="Ingrese la Descripcion" value="${resultado.descripcionLugar}" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="txtsalario" class="col-lg-2 control-label">Fecha:</label>
                    <div class="col-lg-6">
                        <fmt:formatDate var="fecha" pattern="MM/dd/yyyy" value="${resultado.fechaLugar}" />
                        <form:input cssClass="form-control date" path="fechaLugar" id="txtFecha" />
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

