<%-- 
    Document   : eliminar
    Created on : 24/08/2016, 06:45:50 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../template.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Historia</title>
    </head>
    <body>
        <br /> <br /> <br />
        <div class="container">
            <div class="row">
                <br />
                <div class="col-md-8"><h1>¿Desea eliminar a esta Historia?</h1></div>
                
                
            </div>

            <form class="form-horizontal" action="${pageContext.request.contextPath}/historia/eliminar/${resultado.idLugar}.htm" method="POST">
                <hr/>
                <div class="form-group">
                    <label for="txtempleadoid" class="col-lg-5 control-label">Id:</label>
                    <div class="col-lg-6">
                        <label for="empleadoid" class="control-label">${resultado.empleadoid}</label>
                    </div>
                </div>

                <div class="form-group" >
                    <label for="txtoficina" class="col-lg-5 control-label">Oficina:</label>
                    <div class="col-lg-6">
                        <label for="txtoficina" class="control-label">${resultado.oficina.nombre}</label>
                    </div>
                </div>

                <div class="form-group" >
                    <label for="txtnombre" class="col-lg-5 control-label">Nombre:</label>
                    <div class="col-lg-6">
                        <label for="txtnombre" class="control-label">${resultado.nombre}</label>
                    </div>
                </div>

                <div class="form-group" >
                    <label for="txtapellido" class="col-lg-5 control-label">Apellido:</label>
                    <div class="col-lg-6">
                        <label for="txtapellido" class="control-label">${resultado.apellido}</label>
                    </div>
                </div>

                <div class="form-group" >
                    <label for="txtsalario" class="col-lg-5 control-label">Salario:</label>
                    <div class="col-lg-6">
                        <label for="txtsalario" class="control-label">${resultado.salario}</label>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-offset-4 col-md-10">
                        <input type="submit" value="Eliminar" class="btn btn-primary" />
                        <a href="${pageContext.request.contextPath}/empleado.htm" class="btn btn-danger">Cancelar</a>
                    </div>
                </div>

            </form>
        </div>
    </body>
</html>

