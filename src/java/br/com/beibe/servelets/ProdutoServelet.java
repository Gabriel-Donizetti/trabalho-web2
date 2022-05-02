<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.servelets;

import br.com.beibe.beans.CategoriaProduto;
import br.com.beibe.beans.Produto;
import br.com.beibe.exception.DAOException;
import br.com.beibe.model.CategoriaModel;
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
@WebServlet(name = "Produto", urlPatterns = {"/Produto"})
public class ProdutoServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = (String) request.getParameter("method");
        if (method.equals("listar")) {
            try {
                request.setAttribute("hidden", true);
                request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                 request.setAttribute("categorias", CategoriaModel.ListarCategorias());
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("editar")) {
            try {
                request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                request.setAttribute("categorias", CategoriaModel.ListarCategorias());
                request.setAttribute("hidden", false);
                String index = (String) request.getParameter("index");
                request.setAttribute("produtoEdicao", ProdutoModel.BuscarProduto(index));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("salvar")) {
            String tipo = (String) request.getParameter("tipo");
            Produto produto = new Produto(
                    request.getParameter("Nome"),
                    request.getParameter("desc"),
                    Float.parseFloat(request.getParameter("Peso")),
                    new CategoriaProduto(request.getParameter("Categoria"))
            );

            if (tipo.equals("inclusao")) {
                try {
                    ProdutoModel.InserirProduto(produto);
                    request.setAttribute("hidden", true);
                    request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                    request.setAttribute("categorias", CategoriaModel.ListarCategorias());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
                    dispatcher.forward(request, response);
                } catch (DAOException ex) {
                    request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            }else{
                try {
                    ProdutoModel.atualizarProduto(produto);
                    request.setAttribute("hidden", true);
                    request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                    request.setAttribute("categorias", CategoriaModel.ListarCategorias());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
                    dispatcher.forward(request, response);
                } catch (DAOException ex) {
                    request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } else if (method.equals("adicionar")) {
            try {
                request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                request.setAttribute("categorias", CategoriaModel.ListarCategorias());
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
            request.setAttribute("hidden", false);
            request.setAttribute("tipo", "inclusao");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.servelets;

import br.com.beibe.beans.CategoriaProduto;
import br.com.beibe.beans.Produto;
import br.com.beibe.exception.DAOException;
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
@WebServlet(name = "Produto", urlPatterns = {"/Produto"})
public class ProdutoServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = (String) request.getParameter("method");
        if (method.equals("listar")) {
            try {
                request.setAttribute("hidden", true);
                request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("editar")) {
            try {
                request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                request.setAttribute("hidden", false);
                String index = (String) request.getParameter("index");
                request.setAttribute("produtoEdicao", ProdutoModel.BuscarProduto(index));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
                dispatcher.forward(request, response);
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } else if (method.equals("salvar")) {
            String tipo = (String) request.getParameter("tipo");
            Produto produto = new Produto(
                    request.getParameter("Nome"),
                    request.getParameter("desc"),
                    Float.parseFloat(request.getParameter("Peso")),
                    new CategoriaProduto(request.getParameter("Categoria"))
            );

            if (tipo.equals("inclusao")) {
                try {
                    ProdutoModel.InserirProduto(produto);
                    request.setAttribute("hidden", true);
                    request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
                    dispatcher.forward(request, response);
                } catch (DAOException ex) {
                    request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }

                try {
                    ProdutoModel.atualizarProduto(produto);
                    request.setAttribute("hidden", true);
                    request.setAttribute("produtos", ProdutoModel.ListarProdutos());
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
                    dispatcher.forward(request, response);
                } catch (DAOException ex) {
                    request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } else if (method.equals("adicionar")) {
            try {
                request.setAttribute("produtos", ProdutoModel.ListarProdutos());
            } catch (DAOException ex) {
                request.setAttribute("erro", "Erro ao carregar tela produtos " + ex);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
            request.setAttribute("hidden", false);
            request.setAttribute("tipo", "inclusao");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Funcionario/CadastroProduto.jsp");
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
>>>>>>> 4dddbae55c171674c17a11881769a08ae7257906
