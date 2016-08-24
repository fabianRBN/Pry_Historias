<%-- 
    Document   : template
    Created on : 07/01/2016, 06:19:54 PM
    Author     : ACJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/sharingan.ico">
    </head>

    <body>
        <header>
            <div class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <a href="${pageContext.request.contextPath}/index.htm" class="navbar-brand">SDRV</a>

                    </div>

                    <div class="navbar-collapse collapse" id="navbar-main">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Men&uacute; del Sistema<span class="caret"></span></a>
                                <ul class="dropdown-menu" aria-labelledby="themes">
                                    <li><a href="${pageContext.request.contextPath}/lugar.htm">Lugares</a></li>
                                    <li><a href="${pageContext.request.contextPath}/historia.htm">Historias</a></li>
                                    
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
        </header>
    </body>
</html>
