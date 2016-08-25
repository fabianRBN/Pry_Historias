<%-- 
    Document   : exito
    Created on : 24/08/2016, 06:58:06 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>&Eacute;xito</title>
    </head>
    <body>
        <br /> <br /> <br />
        <div class="container">
            <h1>Transacci&oacute;n realizada con &eacute;xito</h1>
            <br />
            <div class="form-group">
                <div class="col-md-offset-4 col-md-10">
                    <a href="${pageContext.request.contextPath}/lugar.htm" class="btn btn-primary">Continuar</a>
                </div>
            </div>
        </div>
    </body>
</html>
