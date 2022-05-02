
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.dao;
import br.com.beibe.beans.CategoriaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.beibe.exception.DAOException;
import java.util.ArrayList;

/**
 *
 * @author Iury
 */
public class CategoriaDAO {
    private static final String QUERY_INSERIR_USER = "INSERT INTO BEIBE.categoriaproduto (nome) VALUES (?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM BEIBE.categoriaproduto WHERE nome = ?";
    private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM BEIBE.categoriaproduto";
    
    private Connection con = null;

    public CategoriaDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar CategoriaDAO");
        }
        this.con = con;
    }
    public void inserir(CategoriaProduto u) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR_USER)) {

            st.setString(1, u.getNome());
            st.executeUpdate();
            //throw new DAOException(st.toString());
        } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e) {
            throw new DAOException("Categoria já cadastrado");
        } catch (SQLException e) {
            throw new DAOException(e.toString());
        }
    }
    
    public CategoriaProduto buscarCategoria(String nome) {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                CategoriaProduto categoria = new CategoriaProduto(
                rs.getString("nome"));
                
                return categoria;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public ArrayList<CategoriaProduto> buscarTodasCategorias() {
        ArrayList<CategoriaProduto> retorno = new ArrayList<CategoriaProduto>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriaProduto categoria = new CategoriaProduto(rs.getString("nome"));
                retorno.add(categoria);
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }
}