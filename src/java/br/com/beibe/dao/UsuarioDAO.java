/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.dao;

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

    private static final String QUERY_INSERIR_USER = "INSERT INTO BEIBE.usuario (nome, cpf, email, telefone, senha, tipo, rua, numero, complemento, bairro, cep, cidade, estado) VALUES (?,?,?,?,HASH('MD5', ?) ,?,?,?,?,?,?,?,?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM BEIBE.usuario WHERE email = ? AND senha = CAST(HASH('MD5', ?) AS VARCHAR)";
    private Connection con = null;

    public UsuarioDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    
    
    public void inserir(Usuario u) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR_USER)) {
            st.setString(1, u.getNome());
            st.setString(2, u.getCpf().replaceAll("\\W+",""));            
            st.setString(3, u.getEmail());
            st.setString(4, u.getTelefone());
            st.setString(5, u.getSenha());
            st.setInt(6, 1); //Tipo é 1 == cliente.
            st.setString(7, u.getRua());
            st.setString(8, u.getNumero());
            st.setString(9, u.getComplemento());  
            st.setString(10, u.getBairro());
            st.setString(11, u.getCep().replaceAll("\\W+",""));
            st.setString(12, u.getCidade());
            st.setString(13, u.getEstado());
  
            
            st.executeUpdate();
             //throw new DAOException(st.toString());

        } catch(org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e){
            throw new DAOException("Usuário já cadastrado");
        }
        catch (SQLException e) {
            throw new DAOException(e.toString());
        }

    }

    public Usuario buscarUser(String email, String senha) {
        
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setString(1, email);
            st.setString(2, senha);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                
                Usuario user = new Usuario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        email,
                        rs.getString("telefone"),
                        rs.getInt("tipo"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("cidade"),
                        rs.getString("estado")
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
