
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %> 
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listagem de todos os atendimentos em Aberto</title>
        <style>@import url("https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap");

            .loader {
                border: 16px solid #f3f3f3;
                border-radius: 50%;
                border-top: 16px solid #3498db;
                width: 120px;
                height: 120px;
                -webkit-animation: spin 2s linear infinite; /* Safari */
                animation: spin 2s linear infinite;
            }

            /* Safari */
            @-webkit-keyframes spin {
                0% { -webkit-transform: rotate(0deg); }
                100% { -webkit-transform: rotate(360deg); }
            }

            @keyframes spin {
                0% { transform: rotate(0deg); }
                100% { transform: rotate(360deg); }
            }

            :root {
                --header-height: 3rem;
                --nav-width: 68px;
                --first-color: #000;
                --first-color-light: #AFA5D9;
                --white-color: #aaa;
                --body-font: 'Nunito', sans-serif;
                --normal-font-size: 1rem;
                --z-fixed: 100
            }

            *,
            ::before,
            ::after {
                box-sizing: border-box
            }

            body {
                position: relative;
                margin: var(--header-height) 0 0 0;
                padding: 0 1rem;
                font-family: var(--body-font);
                font-size: var(--normal-font-size);
                transition: .5s
            }

            a {
                text-decoration: none
            }

            .header {
                width: 100%;
                height: var(--header-height);
                position: fixed;
                top: 0;
                left: 0;
                display: flex;
                align-items: center;
                justify-content: space-between;
                padding: 0 1rem;
                background-color: var(--white-color);
                z-index: var(--z-fixed);
                transition: .5s
            }

            .header_toggle {
                color: var(--first-color);
                font-size: 1.5rem;
                cursor: pointer
            }

            .header_img {
                width: 35px;
                height: 35px;
                display: flex;
                justify-content: center;
                border-radius: 50%;
                overflow: hidden
            }

            .header_img img {
                width: 40px
            }

            .l-navbar {
                position: fixed;
                top: 0;
                left: -30%;
                width: var(--nav-width);
                height: 100vh;
                background-color: var(--first-color);
                padding: .5rem 1rem 0 0;
                transition: .5s;
                z-index: var(--z-fixed)
            }

            .nav {
                height: 100%;
                display: flex;
                flex-direction: column;
                justify-content: space-between;
                overflow: hidden
            }

            .nav_logo,
            .nav_link {
                display: grid;
                grid-template-columns: max-content max-content;
                align-items: center;
                column-gap: 1rem;
                padding: .5rem 0 .5rem 0.3rem
            }

            .inverter {
                filter: invert(1);
            }

            .nav_logo {
                margin-bottom: 2rem
            }

            .nav_logo-icon {
                font-size: 1.25rem;
                color: var(--white-color)
            }

            .nav_logo-name {
                color: var(--white-color);
                /*font-weight: 600*/
                font-size: 11px;
            }

            .nav_link {
                position: relative;
                color: var(--first-color-light);
                margin-bottom: 1.5rem;
                transition: .3s
            }

            .nav_link:hover {
                color: var(--white-color)
            }

            .nav_icon {
                font-size: 1.25rem
            }

            .show {
                left: 0
            }

            .body-pd {
                padding-left: calc(var(--nav-width) + 1rem)
            }

            .active {
                color: var(--white-color)
            }

            .active::before {
                content: '';
                position: absolute;
                left: 0;
                width: 2px;
                height: 32px;
                background-color: var(--white-color);
            }

            .height-100 {
                height: 100vh
            }

            @media screen and (min-width: 768px) {
                body {
                    margin: calc(var(--header-height) + 1rem) 0 0 0;
                    padding-left: calc(var(--nav-width) + 2rem)
                }

                .header {
                    height: calc(var(--header-height) + 1rem);
                    padding: 0 2rem 0 calc(var(--nav-width) + 2rem)
                }

                .header_img {
                    width: 40px;
                    height: 40px
                }

                .header_img img {
                    width: 45px
                }

                .l-navbar {
                    left: 0;
                    padding: 1rem 1rem 0 0
                }
                /*
                    .show {
                        width: calc(var(--nav-width) + 156px)
                    }*/

                .body-pd {
                    padding-left: calc(var(--nav-width) + 188px)
                }
            }

        </style>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body id="body-pd">
        
        <c:if test="${empty sessionScope.usuario.nome}" >
            <c:redirect url="/index.jsp">
                <c:param name="erro" value="Sessão expirou" />
            </c:redirect>
        </c:if>

<c:if test="${sessionScope.usuario.tipo == 1 }" >
            <c:redirect url="/logout.jsp">
                <c:param name="erro" value="Acesso negado." />
            </c:redirect>   
        </c:if>
        <header class="header" id="header">
            <div class="header_toggle"> <i class='bx bx-menu' id="header-toggle"></i> </div>
            <div class="header_img"> <img src="https://i.imgur.com/hczKIze.jpg" alt="Sua foto" title="Joãozinho very crazy"> </div>
        </header>
        <div class="l-navbar" id="nav-bar">
            <nav class="nav">
                <div>
                    <a href="#" class="nav_logo">
                        <i class='bx bx-layer nav_logo-icon'></i>
                        <span class="nav_logo-name">BEIBE</span> </a>
                    <div class="nav_list">
                        <a href="${pageContext.request.contextPath}/Produto?method=listar" class=" nav_link">
                            <i class='bx bx-user nav_icon'></i>
                            <span class="nav_name"><img src="https://cdn-icons.flaticon.com/png/512/3775/premium/3775383.png?token=exp=1651593926~hmac=979eeaaf12ee750680a83e0c53af70ce" width="25" class="inverter" height="25"
                                                        alt="Cadastro de Produtos" title="Cadastro de Produtos"></span>
                        </a>
                        <a href="${pageContext.request.contextPath}/Categoria?method=listar" class="nav_link">
                            <i class='bx bx-message-square-detail nav_icon'></i>
                            <span class="nav_name"><img src="https://cdn-icons-png.flaticon.com/512/1077/1077340.png" width="25" class="inverter" height="25"
                                                               alt="Cadastro de Categorias" title="Cadastro de Categorias"></span>
                        </a>
                        <a href="${pageContext.request.contextPath}/Atendimento?method=listarAtendimentos" class="active nav_link">
                            <i class='bx bx-folder nav_icon'></i>
                            <span class="nav_name"><img src="https://cdn-icons-png.flaticon.com/512/6571/6571852.png" width="25" class="inverter" height="25"
                                                        alt="Listagem de todos os atendimentos" title="Listagem de todos os atendimentos"></span>
                        </a>
                        <a href="${pageContext.request.contextPath}/Atendimento?method=listarAtendimentosAbertos" class="nav_link">
                            <i class='bx bx-folder nav_icon'></i>
                            <span class="nav_name"><img src="https://cdn-icons-png.flaticon.com/512/484/484270.png" width="25" class="inverter" height="25"
                                                        alt="Listagem de todos os atendimentos" title="Listagem de todos os atendimentos em aberto"></span>
                        </a>
                    </div>
                </div>
                 <a href="${pageContext.request.contextPath}/logout.jsp" class="nav_link"> 
                <i class='bx bx-log-out nav_icon'></i> 
                <span class="nav_name"><img src="https://cdn-icons.flaticon.com/png/512/3889/premium/3889524.png?token=exp=1651591278~hmac=8958520d13e289d385a152ae41417dad" width="20" class="inverter" height="20" alt="Logout" title="Logout"></span> 
            </a>
            </nav>
        </div>

        <div class="height-100 bg-light">
            <br><br><br>
            <h4>Atendimentos todos atendimentos</h4>

            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Data/Hora</th>
                        <th scope="col">Cliente</th>
                        <th scope="col">Situação do Atendimento</th>
                        <th scope="col">Produto</th>
                        <th scope="col">tipo do atendimento</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Solução Apresentada</th>
                        <th scope="col">Detalhes</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.atendimentos}" var="atendimento" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.count}</th>
                            <td><fmt:formatDate value="${atendimento.data}" pattern="dd/MM/yyyy" /></td>
                            <td><c:out value="${atendimento.cliente.nome}"/></td>
                            <td><c:out value="${atendimento.situacaoAtendimento}"/></td>
                            <td><c:out value="${atendimento.produto.nome}"/></td>
                            <td><c:out value="${atendimento.tipoAtendimento.nome}"/></td>
                            <td><c:out value="${atendimento.descricao}"/></td>
                            <td><c:out value="${atendimento.solucao}"/></td>
                            <td><a href="${pageContext.request.contextPath}/Atendimento?method=procurar&index=${atendimento.id}">Abrir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="script.js"></script>
    </body>
</html>
