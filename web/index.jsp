<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %> 
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<body>
    <div class="container">
        <div class="row">
          <div class="col-md-6 offset-md-3">
            <div class="card my-5">
              <form class="card-body cardbody-color p-lg-5" action="autenticacao?method=login" method="post" >
                <div class="text-center">
                    <h1 class="text-center text-dark mt-5">Login</h1>
                </div>
                <div class="mb-3">
                  <input type="email" class="form-control" id="Email" aria-describedby="emailHelp" name="Email"
                    placeholder="E-mail">
                </div>
                <div class="mb-3">
                  <input type="password" class="form-control" id="password" placeholder="Senha" name="Senha">
                </div>
                <div class="text-center"><button type="submit" class="btn btn-color px-5 w-100">Login</button>
                    <div class="text-danger">${requestScope.erro}</div></div>
                <div id="emailHelp" class="form-text text-center mt-5 mb-5 text-dark">Não tem uma conta? <a href="register.jsp" class="text-dark fw-bold">Criar conta</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
</body>
</html>