package br.com.beibe.servelets;

import br.com.beibe.beans.Usuario;
import br.com.beibe.exception.DAOException;

import br.com.beibe.model.GerenteModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenteServlet", urlPatterns = {"/GerenteServlet"})
public class GerenteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = (String) request.getParameter("method");
        if (method.equals("listar")) {
            try {
                request.setAttribute("hidden", true);
                request.setAttribute("usuarios", GerenteModel.ListarUsuarios());
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Gerente/CadastroFuncionariosGerentes.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela usuarios " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("salvar")) {
            String tipo = (String) request.getParameter("tipo");

            int type = 1;
            String t = "";
            try {
                t = request.getParameter("Tipo");
                if (t.equals("Gerente")) {
                    type = 3;
                } else if (t.equals("Funcionario")) {
                    type = 2;
                } else {
                    type = 1;
                }
            } catch (Exception e) {
            }

            Usuario user = new Usuario(
                    request.getParameter("NomeCompleto"),
                    request.getParameter("CPF"),
                    request.getParameter("Email"),
                    request.getParameter("Telefone"),
                    type,
                    request.getParameter("Rua"),
                    request.getParameter("Numero"),
                    request.getParameter("Complemento"),
                    request.getParameter("Bairro"),
                    request.getParameter("CEP"),
                    request.getParameter("Cidade"),
                    request.getParameter("Estado")
            );

            if (tipo.equals("inclusao")) {
                try {
                    user.setSenha(request.getParameter("Senha"));
                    GerenteModel.InserirUsuario(user);
                    request.setAttribute("hidden", true);
                    request.setAttribute("usuarios", GerenteModel.ListarUsuarios());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Gerente/CadastroFuncionariosGerentes.jsp");
                    dispatcher.forward(request, response);
                } catch (DAOException ex) {
                    request.setAttribute("erro", "Erro ao carregar tela usuarios " + ex);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                try {
                    GerenteModel.atualizarUsuario(user);
                    request.setAttribute("hidden", true);
                    request.setAttribute("usuarios", GerenteModel.ListarUsuarios());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Gerente/CadastroFuncionariosGerentes.jsp");
                    dispatcher.forward(request, response);

                } catch (DAOException ex) {
                    request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            }

        } else if (method.equals("editar")) {
            try {
                request.setAttribute("usuarios", GerenteModel.ListarUsuarios());
                request.setAttribute("hidden", false);
                String index = (String) request.getParameter("index");
                request.setAttribute("usuarioEdicao", GerenteModel.BuscarUsuarios(index));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Gerente/CadastroFuncionariosGerentes.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("adicionar")) {
            try {
                request.setAttribute("usuarios", GerenteModel.ListarUsuarios());
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela usuarios " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
            request.setAttribute("hidden", false);
            request.setAttribute("tipo", "inclusao");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Gerente/CadastroFuncionariosGerentes.jsp");
            dispatcher.forward(request, response);
        } else {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
