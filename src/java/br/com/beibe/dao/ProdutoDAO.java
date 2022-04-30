/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.dao;

import br.com.beibe.beans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.beibe.exception.DAOException;

/**
 *
 * @author Iury
 */
public class ProdutoDAO {
    
    private static final String QUERY_INSERIR_USER = "INSERT INTO BEIBE.produto (nome, categoria, descricao, peso) VALUES (?,?,?,?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM BEIBE.produto WHERE nome = ?";
    private Connection con = null;

    public ProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }
    public void inserir(Produto u) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR_USER)) {
            st.setString(1, u.getNome());           
            st.executeUpdate();
             //throw new DAOException(st.toString());

        } catch(org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e){
            throw new DAOException("Produto já cadastrado");
        }
        catch (SQLException e) {
            throw new DAOException(e.toString());
        }

    }

    public Produto buscarProduto(String nome) {
        
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setString(1, nome);
            
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                
                Produto prod = new Produto(
                        
                );
                
                return prod;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }

    }
    
}
