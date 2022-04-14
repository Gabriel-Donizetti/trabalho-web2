<%-- 
    Document   : erro
    Created on : 05/04/2022, 16:40:32
    Author     : Rafael Kulka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="style/erro.css" rel="stylesheet">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="error-template">
                        <h1>Oops!</h1>
                        <h2>${requestScope.Title}</h2>
                        <div class="error-details">
                            ${requestScope.Error}
                        </div>
                        <div class="error-actions">
                            <a href="http://www.jquery2dotnet.com" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                                Take Me Home </a><a href="http://www.jquery2dotnet.com" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contact Support </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
