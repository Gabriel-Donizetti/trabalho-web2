/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.model;

import br.com.beibe.beans.Usuario;
import br.com.beibe.dao.ConnectionFactory;
import br.com.beibe.dao.UsuarioDAO;

/**
 *
 * @author Rafael Kulka
 */
public class Autenticacao {

    public static Usuario login(String email, String senha) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
            return dao.buscarUser(email, senha);
        } catch (Exception exc) {
            Exception exception = new Exception("Erro desconheicdo" + exc);
            return null;
        }
    }

    public static Usuario register(Usuario user) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            UsuarioDAO dao = new UsuarioDAO(factory.getConnection());
            dao.inserir(user);
            return user;
        } catch (Exception ex) {
            Exception exception = new Exception("Falha ao cadastrar usuário" + ex);
            return null;
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
