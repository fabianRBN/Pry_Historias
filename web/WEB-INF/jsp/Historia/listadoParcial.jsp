<%-- 
    Document   : listadoParcial
    Created on : 21/08/2016, 07:26:59 PM
    Author     : Fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<hr/>
<table class="table table-condensed table-hover">    
    <tbody>         
        <c:forEach items="${requestScope.historias}" var="r">
            <tr>
                <td>${r.nombreHistoria}</td>
                <td>${r.descripcionHistoria}</td>
                <td></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
