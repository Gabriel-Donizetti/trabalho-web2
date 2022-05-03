/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.servelets;

import br.com.beibe.beans.Usuario;
import br.com.beibe.beans.Atendimento;
import br.com.beibe.exception.DAOException;
import br.com.beibe.model.AtendimentoOperacoes;
import static br.com.beibe.model.AtendimentoOperacoes.gerarBeanAtendimento;
import br.com.beibe.model.ProdutoModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael Kulka
 */
@WebServlet(name = "Atendimento", urlPatterns = {"/Atendimento"})
public class AtendimentoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getSession().getAttribute("usuario") == null) {
            request.setAttribute("erro", "Sessão expirou");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        Usuario validar = (Usuario)request.getSession().getAttribute("usuario");
        
        String path = "";
        if(validar.getTipo() == 2){
            path = "Funcionario";
        }else if(validar.getTipo() ==3){
            path = "Gerente";
        } 
        
        String method = (String) request.getParameter("method");
        
        if (method.equals("deletar")) {
            String index = (String) request.getParameter("index");
            try {
                request.setAttribute("retorno", AtendimentoOperacoes.deletarAtendimento(Integer.parseInt(index)));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Atendimento?method=listar");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar atendimentos" + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }

        } else if (method.equals("procurar")) {
            String index = (String) request.getParameter("index");
            try {
                request.setAttribute("atendimento", AtendimentoOperacoes.buscarAtendimento(Integer.parseInt(index)));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Cliente/AtendimentoCliente.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar atendimentos" + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }

        } else if (method.equals("listarAtendimentosAbertos")) {
            try {
                request.setAttribute("atendimentos", AtendimentoOperacoes.ListarTodosAtendimentosAbertos());
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + path + "/ListagemAtendimentosAberto.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar atendimentos" + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("listarAtendimentos")) {
            try {
                request.setAttribute("atendimentos", AtendimentoOperacoes.ListarTodosAtendimentos());
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + path + "/ListagemAtendimentos.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar atendimentos" + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }

        } else if (method.equals("cadastrar")) {
            Usuario user = (Usuario) request.getSession().getAttribute("usuario");
            try {
                Atendimento a = gerarBeanAtendimento(
                        user,
                        request.getParameter("Produto"),
                        request.getParameter("Descricao"),
                        request.getParameter("Tipo")
                );

                AtendimentoOperacoes.InserirAtendimento(a);

                request.setAttribute("atendimentos", AtendimentoOperacoes.ListarAtendimentos(user.getCpf()));

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Cliente/ListarAtendimentos.jsp");
                dispatcher.forward(request, response);

            } catch (DAOException e) {
                request.setAttribute("Error", e);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
                dispatcher.forward(request, response);
            }

        } else if (method.equals("carregar")) {
            try {
                request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Cliente/CriarAtendimento.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar atendimentos" + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("listar")) {
            try {
                Usuario user = (Usuario) request.getSession().getAttribute("usuario");
                request.setAttribute("atendimentos", AtendimentoOperacoes.ListarAtendimentos(user.getCpf()));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Cliente/ListarAtendimentos.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar atendimentos" + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            //erro
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
