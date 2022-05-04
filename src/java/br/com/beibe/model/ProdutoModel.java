
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.model;

import br.com.beibe.beans.Produto;
import br.com.beibe.dao.ConnectionFactory;
import br.com.beibe.dao.ProdutoDAO;
import br.com.beibe.exception.DAOException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Kulka
 */
public class ProdutoModel {

    public static ArrayList<Produto> ListarProdutos() throws DAOException {
        ArrayList<Produto> retorno = new ArrayList<Produto>();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ProdutoDAO dao = new ProdutoDAO(factory.getConnection());
            retorno = dao.buscarTodosProduto();
        } catch (Exception exc) {
            throw new DAOException("Erro ao listar produtos: " + exc);
        }
        return retorno;
    }

    public static Produto BuscarProduto(String nome) throws DAOException {
        Produto retorno = new Produto();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ProdutoDAO dao = new ProdutoDAO(factory.getConnection());
            retorno = dao.buscarProduto(nome);
        } catch (Exception exc) {
            throw new DAOException("Erro ao buscar produto: " + exc);
        }
        return retorno;
    }

    public static void atualizarProduto(Produto p) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ProdutoDAO dao = new ProdutoDAO(factory.getConnection());
            dao.atualizar(p);
        } catch (Exception exc) {
            throw new DAOException("Erro ao atualizar produto: " + exc);
        }        
    }

    public static void InserirProduto(Produto p) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ProdutoDAO dao = new ProdutoDAO(factory.getConnection());
            dao.inserir(p);
        } catch (Exception exc) {
            throw new DAOException("Erro ao inserir produto: " + exc);
        }
        //return retorno;
    }
    
    public static void deletarProduto(Produto p) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ProdutoDAO dao = new ProdutoDAO(factory.getConnection());
            dao.deletar(p);
        } catch (Exception exc) {
            throw new DAOException("Erro ao inserir produto: " + exc);
        }
        //return retorno;
    }

}
