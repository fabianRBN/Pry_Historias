<%-- 
    Document   : error
    Created on : 07/11/2016, 05:56:09 PM
    Author     : ACJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="template.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <br /> <br /> <br />
        <div class="container">
            <h1>Error: ${requestScope.err}</h1>
            <br />
            <div class="form-group">
                <div class="col-md-offset-4 col-md-10">
                    <a href="${pageContext.request.contextPath}/index.htm" class="btn btn-primary">Continuar</a>
                </div>
            </div>
        </div>
    </body>
</html>