<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body >
        <c:if test="${empty sessionScope.usuario.nome}" >
            <c:redirect url="/index.jsp">
                <c:param name="erro" value="Sessão expirou" />
            </c:redirect>
        </c:if>

        <c:if test="${sessionScope.usuario.tipo != 2}" >
            <c:redirect url="/logout.jsp">
                <c:param name="erro" value="Acesso negado." />
            </c:redirect>   
        </c:if>
        
        <c:redirect url="/Atendimento?method=listarAtendimentosAbertos  "/> <!--colocar aberto-->
    </body>

</html>
