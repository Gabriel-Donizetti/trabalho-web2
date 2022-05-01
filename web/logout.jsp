<%-- 
    Document   : logout
    Created on : 01/05/2022, 10:34:14
    Author     : Rafael Kulka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% session.invalidate(); %>
        <c:redirect url="/index.jsp"> </c:redirect>
    </body>
</html>
