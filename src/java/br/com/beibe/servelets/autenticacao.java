/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.servelets;

import br.com.beibe.beans.Usuario;
import br.com.beibe.exception.DAOException;
import br.com.beibe.model.Autenticacao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    private static HttpURLConnection conexao;
    BufferedReader leitor;
    String linha;
    StringBuffer conteudo = new StringBuffer();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = (String) request.getParameter("method");
        if (method.equals("login")) {
            Usuario user = null;
            try {
                user = Autenticacao.login(request.getParameter("Email"), request.getParameter("Senha"));
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao logar " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", user);
                if (user.getTipo() == 1) { //Cliente
                    response.sendRedirect(request.getContextPath() + "/Cliente/Index.jsp");
                }
                if (user.getTipo() == 2) { // Funcionario 
                    response.sendRedirect(request.getContextPath() + "/Funcionario/Index.jsp");
                }
                if (user.getTipo() == 3) { //Gerente 
                    response.sendRedirect(request.getContextPath() + "/Gerente/Index.jsp");
                }
                //response.sendRedirect(request.getContextPath() + "/Gerente/ListagemAtendimentos.jsp");
            } else {
                request.setAttribute("erro", "usuário ou senha inválidos.");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }

        } else if (method.equals("register")) {

            Usuario user = new Usuario(
                    request.getParameter("Nome"),
                    request.getParameter("CPF"),
                    request.getParameter("Email"),
                    request.getParameter("Telefone"),
                    1,
                    request.getParameter("Senha"),
                    request.getParameter("Rua"),
                    request.getParameter("Numero"),
                    request.getParameter("Complemento"),
                    request.getParameter("Bairro"),
                    request.getParameter("CEP"),
                    request.getParameter("Cidade"),
                    request.getParameter("Estado")
            );
            //if(Autenticacao.validarUser(user).isEmpty()){
            //Usuario usuario = null;
            try {
                Autenticacao.register(user);
                HttpSession session = request.getSession();
                session.setAttribute("usuario", user);
            } catch (DAOException e) {
                request.setAttribute("erro", "usuário não cadastrado. " + e);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }

            //} else {
            // request.setAttribute("erro", "usuário não cadastrado.");
            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            //dispatcher.forward(request, response);
            //}
        } else if (method.equals("cep")) {
            
            /*
            try {
                //CONEXÃO COM API CEP MÉTODO 1
                cep = request.getParameter("CEP")
                URL url = new URL("http://viacep.com.br/ws/81530350/json/");
                conexao = (HttpURLConnection) url.openConnection();
                conexao.setRequestMethod("GET");
                conexao.setConnectTimeout(5000);
                conexao.setReadTimeout(5000);
                int status = conexao.getResponseCode();
               // Status da resposta System.out.println(status);
                if (status > 299){
                    leitor = new BufferedReader(new InputStreamReader(conexao.getErrorStream()));
                    while((linha = leitor.readLine())!=null){
                        conteudo.append(linha);
                    }
                    leitor.close();
                }else{
                    leitor = new BufferedReader (new InputStreamReader(conexao.getInputStream()));
                    while((linha = leitor.readLine())!=null){
                        conteudo.append(linha);                                           
                    }
                    leitor.close();
                }                    
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            } finally{
                conexao.disconnect();
            }*/
        
            
            
            

        } else if (method.equals("logout")) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.removeAttribute("usuario");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
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
