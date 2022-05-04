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
         <c:if test="${empty sessionScope.usuario.nome}" >
            <c:redirect url="/index.jsp">
                <c:param name="erro" value="Sessão expirou" />
            </c:redirect>
        </c:if>

        <c:if test="${sessionScope.usuario.tipo != 3}" >
            <c:redirect url="/logout.jsp">
                <c:param name="erro" value="Acesso negado." />
            </c:redirect>   
        </c:if>
        
        <c:redirect url="/GerenteServlet?method=listar"/> <!--colocar aberto-->
    </body>
</html>
