<%-- 
    Document   : ListagemAtendimentosAberto
    Created on : 20/04/2022, 14:00:17
    Author     : Iury
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Listagem de todos os atendimentos em Aberto</title>
      <link rel="stylesheet" href="style.css">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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
   </div>
   <div class="height-100 bg-light">
       <br><br><br>
      <h4>Atendimentos em aberto</h4>

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
          </tr>
       </thead>
       <tbody>
          <tr>
             <th scope="row">1</th>
             <td>25/12/2009 00:12:31</td>
             <td>Michael Jackson</td>
             <td>Aguardando</td>
             <td>Rimel</td>
             <td>Reclamação</td>
             <td>Alergia nos zoio</td>
             <td>Um olho novo</td>
          </tr>
          <tr style="background-color: red;">
             <th scope="row">2</th>
             <td>25/12/2009 00:12:31</td>
             <td>Michael Jackson</td>
             <td>Aguardando</td>
             <td>Rimel</td>
             <td>Reclamação</td>
             <td>Alergia nos zoio</td>
             <td>Um olho novo</td>
          </tr>
          <tr>
             <th scope="row">3</th>
             <td>25/12/2009 00:12:31</td>
             <td>Michael Jackson</td>
             <td>Aguardando</td>
             <td>Rimel</td>
             <td>Reclamação</td>
             <td>Alergia nos zoio</td>
             <td>Um olho novo</td>
          </tr>
       </tbody>
    </table>
   </div>
</body>
</html>
