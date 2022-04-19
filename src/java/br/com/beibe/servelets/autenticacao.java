/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.servelets;

import br.com.beibe.beans.Usuario;
import br.com.beibe.dao.ConnectionFactory;
import br.com.beibe.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rafael Kulka
 */
@WebServlet(name = "autenticacao", urlPatterns = {"/autenticacao"})
public class autenticacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = (String) request.getParameter("method");
        if (method.equals("login")) {

            try (ConnectionFactory factory = new ConnectionFactory()) {
                UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
                Usuario user = dao.buscarUser(request.getParameter("Email"), request.getParameter("Senha"));
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", user.getNome());
                    response.sendRedirect(request.getContextPath() + "/Gerente/ListagemAtendimentos.jsp");

                } else {
                    request.setAttribute("erro", "usuário ou senha inválidos.");
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }

            } catch (Exception exc) {
                request.setAttribute("erro", "erro desconhecido.");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("register")) {
            try (ConnectionFactory factory = new ConnectionFactory()) {
                Usuario user = new Usuario();
                user.setEmail(request.getParameter("Email"));
                user.setSenha(request.getParameter("Senha"));
                user.setNome(request.getParameter("Nome"));
                user.setCPF("");
                user.setTelefone("");
                UsuarioDAO dao = new UsuarioDAO(factory.getConnection());

                dao.inserir(user);

            } catch (Exception ex) {
                //out.println(ex.toString);
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
