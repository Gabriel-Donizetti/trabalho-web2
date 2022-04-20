<%-- 
    Document   : CadastroCategoria
    Created on : 20/04/2022, 13:56:51
    Author     : Iury
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Cadastro Produto</title>
   <link rel="stylesheet" href="style.css">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
      integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
      crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"></script>
</head>

<body id="body-pd">
   <header class="header" id="header">
      <div class="header_toggle"> <i class='bx bx-menu' id="header-toggle"></i> </div>
      <div class="header_img"> <img src="https://i.imgur.com/hczKIze.jpg" alt="Sua foto" title="Joãozinho very crazy">
      </div>
   </header>
   <div class="l-navbar" id="nav-bar">
      <nav class="nav">
         <div>
            <a href="#" class="nav_logo">
               <i class='bx bx-layer nav_logo-icon'></i>
               <span class="nav_logo-name">BEIBE</span> </a>
            <div class="nav_list">
               <a href="cadastroProduto.html" class="nav_link">
                  <i class='bx bx-user nav_icon'></i>
                  <span class="nav_name"><img src="icon/addProduto.png" width="25" class="inverter" height="25"
                        alt="Cadastro de Produtos" title="Cadastro de Produtos"></span>
               </a>
               <a href="cadastroCategoria.html" class="nav_link">
                  <i class='bx bx-message-square-detail nav_icon'></i>
                  <span class="active nav_name"><img src="icon/addCategoria.png" width="25" class="inverter" height="25"
                        alt="Cadastro de Categorias" title="Cadastro de Categorias"></span>
               </a>
               <a href="resolucaoAtendimento.html" class="nav_link">
                  <i class='bx bx-bookmark nav_icon'></i>
                  <span class="nav_name"><img src="icon/resolucaoatendimento.png" width="25" class="inverter"
                        height="25" alt="Resolução Atendimentos" title="Resolução Atendimentos"></span>
               </a>
               <a href="listagemAtendimentos.html" class="nav_link">
                  <i class='bx bx-folder nav_icon'></i>
                  <span class="nav_name"><img src="icon/atendimento.png" width="25" class="inverter" height="25"
                        alt="Listagem de todos os atendimentos" title="Listagem de todos os atendimentos"></span>
               </a>
               <a href="listagemAtendimentosAberto.html" class="nav_link">
                  <i class='bx bx-folder nav_icon'></i>
                  <span class="nav_name"><img src="icon/atendimentoAberto.png" width="25" class="inverter" height="25"
                        alt="Listagem de todos os atendimentos" title="Listagem de todos os atendimentos"></span>
               </a>
            </div>

         </div>
         <a href="#" class="nav_link">
            <i class='bx bx-log-out nav_icon'></i>
            <span class="nav_name"><img src="icon/Logout.png" width="25" class="inverter" height="25" alt="Logout"
                  title="Logout"></span>
         </a>
      </nav>
   </div>
   <div class="height-100 bg-light">
      <br><br><br>
      <h4>Lista de Produtos</h4>
      <table class="table">
         <thead class="thead-dark">
            <tr>
               <th scope="col">#</th>
               <th scope="col">Nome</th>
               <th scope="col">Ações</th>
            </tr>
         </thead>
         <tbody>
            <tr>
               <th scope="row">1</th>

               <td>Batom</td>
               <td><a href="#" onclick="Edit()">Editar</a>&nbsp;<a href="#" data-toggle="modal"
                     data-target="#meuModal">Deletar</a></td>

            </tr>
            <tr>
               <th scope="row">2</th>

               <td>Maquiagem</td>

               <td><a href="#" onclick="Edit()">Editar</a>&nbsp;<a href="#" data-toggle="modal"
                     data-target="#meuModal">Deletar</a></td>
            </tr>
            <tr>
               <th scope="row">3</th>

               <td>Óleos</td>

               <td><a href="#" onclick="Edit()">Editar</a>&nbsp;<a href="#" data-toggle="modal"
                     data-target="#meuModal">Deletar</a></td>
            </tr>
         </tbody>
      </table>
      <div id="cadastro">
         <h4>Cadastro de Categoria</h4>
         <div class="form-group">

            <label for="exampleFormControlSelect1">Categoria :</label>
            <input type="text" name="Categoria" id="" class="form-control" value="#">

            <br>
            <button type="submit" class="btn btn-primary">Salvar</button>
         </div>

      </div>


   </div>

   <div id="meuModal" class="modal fade" role="dialog">
      <div class="modal-dialog">

         <!-- Conteúdo do modal-->
         <div class="modal-content">

            <!-- Cabeçalho do modal -->
            <div class="modal-header">
               <h4 class="modal-title">Confirmar</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Corpo do modal -->
            <div class="modal-body">
               <p>Confima a exclusão?</p>
               <p>(Essa alteração é irreversível)</p>
            </div>

            <!-- Rodapé do modal-->
            <div class="modal-footer">
               <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
               <button type="button" class="btn btn-primary" data-dismiss="modal">Confirmar</button>
            </div>

         </div>
      </div>
   </div>

   <script src="script.js"></script>
   <script>
      document.getElementById("cadastro").hidden = true;

      function Edit() {
         document.getElementById("cadastro").hidden = false;
      }

   </script>
</body>

</html>
