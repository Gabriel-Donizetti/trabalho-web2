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
/**
 *
 * @author Rafael Kulka
 */
public class Autenticacao {

    public static Usuario login(String email, String senha) throws DAOException  {
        Usuario retorno = null  ;
        try (ConnectionFactory factory = new ConnectionFactory()) {
            UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
            retorno = dao.buscarUser(email, senha);
        } catch (Exception exc) {
            throw new DAOException("Usuário não localizado.");
        }
        return retorno;
    }

    public static Usuario register(Usuario user) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
            dao.inserir(user);
            return user;
        } catch (Exception ex) {
            throw new DAOException("Não foi possivel inserir usuário." + ex);
        }

    }
    
    public static String validarUser(Usuario user){
        if(user  != null){
            return "";
        }else{
            return "user null.";
        }
    }
}
