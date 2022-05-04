/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.model;

import br.com.beibe.beans.Usuario;
import br.com.beibe.dao.ConnectionFactory;

import br.com.beibe.dao.UsuarioDAO;
import br.com.beibe.exception.DAOException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Kulka
 */
public class GerenteModel {

    public static ArrayList<Usuario> ListarUsuarios() throws DAOException {
        ArrayList<Usuario> retorno = new ArrayList<Usuario>();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
            retorno = dao.buscarTodosUsuarios();
        } catch (Exception exc) {
            throw new DAOException("Erro ao listar Usuarios: " + exc);
        }
        return retorno;
    }

    public static Usuario BuscarUsuarios(String cpf) throws DAOException {
        Usuario retorno = new Usuario();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
            retorno = dao.buscarUser(cpf);
        } catch (Exception exc) {
            throw new DAOException("Erro ao listar Usuarios: " + exc);
        }
        return retorno;
    }

    public static void atualizarUsuario(Usuario u) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
            dao.atualizar(u);
        } catch (Exception exc) {
            throw new DAOException("Erro ao atualizar Usuario: " + exc);
        }
    }

    public static void InserirUsuario(Usuario p) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
            dao.inserirGerente(p);
        } catch (Exception exc) {
            throw new DAOException("Erro ao inserir produto: " + exc);
        }
        //return retorno;
    }

}
