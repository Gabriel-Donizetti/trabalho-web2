/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.model;

import br.com.beibe.beans.CategoriaProduto;
import br.com.beibe.dao.ConnectionFactory;
import br.com.beibe.dao.CategoriaDAO;
import br.com.beibe.exception.DAOException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Kulka
 */
public class CategoriaModel {
    public static ArrayList<CategoriaProduto> ListarCategorias() throws DAOException {
        ArrayList<CategoriaProduto> retorno = new ArrayList<CategoriaProduto>();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            CategoriaDAO dao = new CategoriaDAO(factory.getConnection());
            retorno = dao.buscarTodasCategorias();
        } catch (Exception exc) {
            throw new DAOException("Erro ao buscar categorias: " + exc);
        }
        return retorno;
    }
public static CategoriaProduto BuscarCategoria(String nome) throws DAOException {
         CategoriaProduto retorno = new CategoriaProduto();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            CategoriaDAO dao = new CategoriaDAO(factory.getConnection());
            retorno = dao.buscarCategoria(nome);
        } catch (Exception exc) {
            throw new DAOException("Erro ao buscar categoria: " + exc);
        }
        return retorno;
    }

    public static void InserirCategoria(CategoriaProduto c) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            CategoriaDAO dao = new CategoriaDAO(factory.getConnection());
            dao.inserir(c);
        } catch (Exception exc) {
            throw new DAOException("Erro ao inserir categoria: " + exc);
        }
        //return retorno;
    }
    
    public static void deletarCategoria(CategoriaProduto c) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            CategoriaDAO dao = new CategoriaDAO(factory.getConnection());
            dao.deletar(c);
        } catch (Exception exc) {
            throw new DAOException("Erro ao deletar categoria : " + exc);
        }
        //return retorno;
    }

}
