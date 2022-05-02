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
}
