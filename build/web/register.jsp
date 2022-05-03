<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card my-5">
                        <form class="card-body cardbody-color p-lg-5" action="autenticacao?method=register" method="post">

                            <div class="text-center">
                                <h1 class="text-center text-dark mt-5">Cadastro</h1>
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="Nome" aria-describedby="emailHelp" name="Nome"
                                       placeholder="Nome">
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="CPF" aria-describedby="emailHelp" name="CPF" onkeydown="javascript: fMasc( this, mCPF );"
                                       placeholder="CPF">
                            </div>

                            <div class="mb-3">
                                <input type="email" class="form-control" id="Email" aria-describedby="emailHelp" name="Email"
                                       placeholder="E-mail">
                            </div>

                            <div class="mb-3">
                                <input type="CEP" class="form-control" id="CEP" aria-describedby="emailHelp" name="CEP" maxlength="10"  placeholder="CEP" onkeydown="javascript: fMasc( this, mCEP );">
                                       
                                
                            </div>
                            <button class="btn btn-color px-5 w-50 mb-3">Buscar</button>

                            <div class="mb-3">
                                <input type="text" class="form-control" id="Rua" aria-describedby="emailHelp" name="Rua"
                                       placeholder="Rua">
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="Numero" aria-describedby="emailHelp" name="Numero"
                                       placeholder="Numero">
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="Bairro" aria-describedby="emailHelp" name="Bairro"
                                       placeholder="Bairro">
                            </div>

                            <div class="mb-3">
                                <input type="text" class="form-control" id="Cidade" aria-describedby="emailHelp" name="Cidade"
                                       placeholder="Cidade">
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="Estado" aria-describedby="emailHelp" name="Estado"
                                       placeholder="Estado">
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control" id="Complemento" aria-describedby="emailHelp" name="Complemento"
                                       placeholder="Complemento">
                            </div>

                            <div class="mb-3">
                                <input type="text" class="form-control" id="Telefone" aria-describedby="emailHelp" name="Telefone"
                                       placeholder="Telefone">
                            </div>
                            <div class="mb-3">
                                <input type="password" class="form-control" id="password" placeholder="Senha" name="Senha">
                            </div>
                            <div class="text-center"><button type="submit" class="btn btn-color px-5 w-100" onclick="ValidaCPF();">Cadastrar</button>
                                
                            <div class="text-danger">${requestScope.erro}</div></div>
                            <div id="emailHelp" class="form-text text-center mt-5 mb-5 text-dark">Já tem uma conta? <a href="index.jsp" class="text-dark fw-bold">Login</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="script.js"></script>
    </body>
</html>