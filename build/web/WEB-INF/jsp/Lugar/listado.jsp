<%-- 
    Document   : listado
    Created on : 20/08/2016, 05:35:35 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../template.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Lugares</title>
    </head>
    <body>
        <br /> <br /> <br />
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1>Lugares</h1>
                </div>

                <div class="col-md-6">
                    <br />
                    <c:if test="${mensaje != ''}">
                        <c:choose>
                            <c:when test="${tipoMensaje == true}">
                                <h4 class="text text-success">${mensaje}</h4>
                            </c:when>
                            <c:otherwise>
                                <h4 class="text text-danger">${mensaje}</h4>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </div>

            </div>

            <a href="${pageContext.request.contextPath}/lugar/crear.htm" class="btn btn-success btn-xs">Nuevo</a>
            <br /><br />
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th class="active">Id</th>
                        <th class="active">Nombre</th>
                        <th class="active">Descripcion</th>
                        <th class="active">Fecha de Fundacion</th>
                        <th class="active"></th>
                        <th class="active"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.resultado}" var="d">
                        <tr>
                            <td>
                                ${d.idLugar}
                            </td>                            
                            <td>
                                ${d.nombreLugar}
                            </td> 
                            <td>
                                ${d.descripcionLugar}   
                            </td>
                            <td>
                                <fmt:formatDate pattern="MM/dd/yyyy" value="${d.fechaLugar}" />
                            </td> 
                            <td>
                                <a href="${pageContext.request.contextPath}/lugar/editar/${d.idLugar}.htm" class="btn btn-primary btn-xs">Editar</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/lugar/eliminar/${d.idLugar}.htm" class="btn btn-danger btn-xs">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
