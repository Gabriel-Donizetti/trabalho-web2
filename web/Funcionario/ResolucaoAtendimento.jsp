<%-- 
    Document   : ResolucaoAtendimento
    Created on : 20/04/2022, 14:01:00
    Author     : Iury
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Resolução Atendimento</title>
      <link rel="stylesheet" href="style.css">
   </head>
   <body id="body-pd">
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
               <a href="CadastroProduto.jsp" class="nav_link">
                  <i class='bx bx-user nav_icon'></i>
                  <span class="nav_name"><img src="icon/addProduto.png" width="25" class="inverter" height="25"
                        alt="Cadastro de Produtos" title="Cadastro de Produtos"></span>
               </a>
               <a href="CadastroCategoria.jsp" class="nav_link">
                  <i class='bx bx-message-square-detail nav_icon'></i>
                  <span class="active nav_name"><img src="icon/addCategoria.png" width="25" class="inverter" height="25"
                        alt="Cadastro de Categorias" title="Cadastro de Categorias"></span>
               </a>
               <a href="ResolucaoAtendimento.jsp" class="nav_link">
                  <i class='bx bx-bookmark nav_icon'></i>
                  <span class="nav_name"><img src="icon/resolucaoatendimento.png" width="25" class="inverter"
                        height="25" alt="Resolução Atendimentos" title="Resolução Atendimentos"></span>
               </a>
               <a href="ListagemAtendimentos.jsp" class="nav_link">
                  <i class='bx bx-folder nav_icon'></i>
                  <span class="nav_name"><img src="icon/atendimento.png" width="25" class="inverter" height="25"
                        alt="Listagem de todos os atendimentos" title="Listagem de todos os atendimentos"></span>
               </a>
               <a href="ListagemAtendimentosAberto.jsp" class="nav_link">
                  <i class='bx bx-folder nav_icon'></i>
                  <span class="nav_name"><img src="icon/atendimentoAberto.png" width="25" class="inverter" height="25"
                        alt="Listagem de todos os atendimentos" title="Listagem de todos os atendimentos"></span>
               </a>
            </div>

         </div>
            <a href="#" class="nav_link"> 
                <i class='bx bx-log-out nav_icon'></i> 
                <span class="nav_name"><img src="icon/Logout.png" width="25" class="inverter" height="25" alt="Logout" title="Logout"></span> 
            </a>
         </nav>
      </div>
      <div class="height-100 bg-light">
         <h4>Main Components</h4>
      </div>
      <script src="script.js"></script>
</html>
