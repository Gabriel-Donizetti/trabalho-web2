<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de usuários</title>
        <link rel="stylesheet" href="style.css">

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
    <body>
        <header class="header" id="header">
            <div class="header_toggle"> <i class='bx bx-menu' id="header-toggle"></i> </div>
            <span>Bem vindo <strong>${sessionScope.usuario.nome}</strong>!</span></b><div class="header_img"><a href="#"><img style="cursor:pointer;" src="data:image/jpeg;base64,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" alt="Sua foto" title="${sessionScope.usuario.nome}"></a></div>
    </header>
    <div class="l-navbar" id="nav-bar">
        <nav class="nav">
            <div>
                <a href="Cliente/index.jsp" class="nav_logo"> 
                    <i class='bx bx-layer nav_logo-icon'></i> 
                    <span class="nav_logo-name">BEIBE</span> </a>
                <div class="nav_list"> 
                    
                    <a href="#" class="nav_link"> 
                        <i class='bx bx-user nav_icon'></i> 
                        <span class="nav_name"><img src="https://cdn-icons-png.flaticon.com/512/747/747376.png" width="20" class="inverter" height="20" alt="Alterar dados perfil" title="Alterar dados do perfil"></span> 
                    </a>    

                    <a href="Atendimento?method=listar" class="nav_link">
                        <i class='bx bx-message-square-detail nav_icon'></i> 
                        <span class="nav_name"><img src="https://cdn-icons-png.flaticon.com/512/484/484270.png" width="20" class="inverter" height="20" alt="Listagem de todos os atendimentos em Aberto" title="Listagem de todos os atendimentos em Aberto"></span> 
                    </a> 
                    <a href="${pageContext.request.contextPath}/Atendimento?method=carregar" class=" active nav_link"> 
                        <i class='bx bx-bookmark nav_icon'></i> 
                        <span class="nav_name"><img src="https://cdn-icons-png.flaticon.com/512/1237/1237946.png" width="20" class="inverter" height="20" alt="Cadastro de atendimento" title="Cadastro de atendimento"></span> 
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
        <br><br><br><br><br>
        <h2>Cadastro de atendimento: </h2>
        <form action="${pageContext.request.contextPath}/Atendimento?method=cadastrar" method="post">
            <div class="form-group">
                <label>Produto:</label>
                <select class="form-select"  name="Produto" id="">
                    <c:forEach items="${requestScope.produtos}" var="produto">
                        <option value="${produto.nome}">
                            <c:out value="${produto.nome}"/>
                        </option>
                    </c:forEach>
                </select>
                <br>
                <label>Tipo</label>
                <!--<input type="text" name="tipo" id="" class="form-control" value="">-->
                <select class="form-select"  name="Tipo" id="">
                    <option selected>Sugestao</option>
                    <option>Reclamacao</option>
                </select>
                <br>
                <label>Descrição</label>
                <input type="text" name="Descricao" id="" class="form-control" value="">    
                <button type="submit" class="btn btn-color px-5 w-100">Cadastrar</button>
            </div>
        </form>
    </div>
</body>
</html>
