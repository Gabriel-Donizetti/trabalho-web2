/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.dao;

import br.com.beibe.beans.Endereco;
import br.com.beibe.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.beibe.exception.DAOException;

/**
 *
 * @author Rafael Kulka
 */
public class UsuarioDAO {

    private static final String QUERY_INSERIR = "INSERT INTO BEIBE.usuario (nome, cpf, email, telefone, senha, tipo) VALUES (?, ?,?,?, ? ,?)";
    private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM BEIBE.usuario T0 INNER JOIN BEIBE.endereco T1 ON T0.endereco = T1.id WHERE email = ? AND senha = ?";
    private Connection con = null;

    public UsuarioDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    public void inserir(Usuario u) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setString(1, u.getNome());
            st.setString(2, u.getCPF());
            st.setString(3, u.getEmail());
            st.setString(4, u.getTelefone());
            st.setString(5, u.getSenha());
            st.setInt(6, 1); //Tipo é 1 == cliente.

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erro inserindo usuário: " + QUERY_INSERIR, e);
        }

    }

    public Usuario buscarUser(String email, String senha) {
        
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            st.setString(1, email);
            st.setString(2, senha);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                
                Endereco endereco = new Endereco(
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("cidade"),
                        rs.getString("estado")
                );
                
                Usuario user = new Usuario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        email,
                        endereco,
                        rs.getString("telefone"),
                        rs.getInt("tipo")
                );
                
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }

    }

}
