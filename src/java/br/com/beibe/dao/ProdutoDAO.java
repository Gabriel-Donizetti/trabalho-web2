/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.dao;

import br.com.beibe.beans.Produto;
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
public class ProdutoDAO {

    private static final String QUERY_INSERIR_PRODUTO = "INSERT INTO BEIBE.produto (nome, categoria, descricao, peso) VALUES (?,?,?,?)";
    private static final String QUERY_ATUALIZAR_PRODUTO = "UPDATE BEIBE.produto SET categoria = ?, descricao = ?, peso = ? WHERE nome = ?";
    private static final String QUERY_BUSCAR = "SELECT * FROM BEIBE.produto WHERE nome = ?";
    private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM BEIBE.produto";
    private static final String QUERY_DELETAR_PRODUTO = "DELETE FROM BEIBE.produto WHERE nome = ?";
    private Connection con = null;

    public ProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar ProdutoDAO");
        }
        this.con = con;
    }

    public void deletar(Produto u) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_DELETAR_PRODUTO)) {
            st.setString(1, u.getNome());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.toString());
        } catch (Exception ex) {
            throw new DAOException(ex.toString());
        }
    }

    public void atualizar(Produto u) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_ATUALIZAR_PRODUTO)) {
            st.setString(1, u.getCategoria().getNome());
            st.setString(2, u.getDescricao());
            st.setFloat(3, u.getPeso());
            st.setString(4, u.getNome());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.toString());
        } catch (Exception ex) {
            throw new DAOException(ex.toString());
        }
    }

    public void inserir(Produto u) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR_PRODUTO)) {

            st.setString(1, u.getNome());
            st.setString(2, u.getCategoria().getNome());
            st.setString(3, u.getDescricao());
            st.setFloat(4, u.getPeso());
            st.executeUpdate();
            //throw new DAOException(st.toString());
        } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e) {
            throw new DAOException("Produto já cadastrado");
        } catch (SQLException e) {
            throw new DAOException(e.toString());
        }
    }

    public Produto buscarProduto(String nome) {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CategoriaProduto categoria = new CategoriaProduto(rs.getString("categoria"));
                Produto prod = new Produto(
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getFloat("peso"),
                        categoria
                );
                return prod;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<Produto> buscarTodosProduto() {
        ArrayList<Produto> retorno = new ArrayList<Produto>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriaProduto categoria = new CategoriaProduto(rs.getString("categoria"));
                Produto prod = new Produto(
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getFloat("peso"),
                        categoria
                );
                retorno.add(prod);
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }
}
