/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.dao;

import br.com.beibe.beans.Atendimento;
import br.com.beibe.beans.CategoriaProduto;
import br.com.beibe.beans.Produto;
import br.com.beibe.beans.TipoAtendimento;
import br.com.beibe.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.beibe.exception.DAOException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rafael Kulka
 */
public class AtendimentoDAO {

    private static final String QUERY_INSERIR_ATENDIMENTO = "INSERT INTO BEIBE.Atendimento (CreateDate, Cliente, Situacao, Produto, TipoAtendimento, Descricao, Solucao) VALUES (NOW(),?,?,?, ? ,?,?)";

    private static final String QUERY_DELETAR_ATENDIMENTO = "DELETE FROM BEIBE.Atendimento WHERE ID = ? AND Situacao = 'Aberto'";
    
    private static final String QUERY_ATENDER_ATENDIMENTO = "UPDATE BEIBE.Atendimento SET SOLUCAO = ?, SITUACAO = 'Finalizado'  WHERE id = ?";

    private static final String QUERY_BUSCAR_TODOS_USUARIO = "SELECT \n"
            + "	CREATEDATE AS \"Atendimento-CreateDate\",   \n"
            + "	id AS \"Atendimento-id\",   \n"
            + "	SITUACAO AS \"Atendimento-Situacao\",  \n"
            + "	T0.DESCRICAO AS \"Atendimento-Descricao\",  \n"
            + "	SOLUCAO AS \"Atendimento-Solucao\", \n"
            + "	T1.NOME AS \"Produto-Nome\",  \n"
            + "	CATEGORIA AS \"Produto-Categoria\",  \n"
            + "	T1.DESCRICAO AS \"Produto-Descricao\",  \n"
            + "	PESO AS \"Produto-Peso\", \n"
            + "	CPF AS \"Usuario-Cpf\",  \n"
            + "	T2.NOME AS \"Usuario-Nome\",\n"
            + "	EMAIl AS \"Usuario-Email\", \n"
            + "	TELEFONE AS \"Usuario-Telefone\",\n"
            + "	TIPO AS \"Usuario-Tipo\",\n"
            + "	RUA AS \"Usuario-Rua\",\n"
            + "	NUMERO AS \"Usuario-Numero\", \n"
            + "	COMPLEMENTO AS \"Usuario-Complemento\",\n"
            + "	BAIRRO AS \"Usuario-Bairro\", \n"
            + "	CEP AS \"Usuario-CEP\", \n"
            + "	CIDADE AS \"Usuario-Cidade\", \n"
            + "	ESTADO AS \"Usuario-Estado\", \n"
            + "	T3.NOME AS \"Atendimento-Nome\" \n"
            + " FROM BEIBE.Atendimento T0 INNER JOIN BEIBE.PRODUTO T1 ON T0.PRODUTO = T1.NOME INNER JOIN BEIBE.USUARIO T2 ON T0.CLIENTE = T2.CPF AND T2.TIPO = 1 AND T2.CPF = ? \n"
            + "INNER JOIN BEIBE.TIPOATENDIMENTO T3 ON T3.NOME = T0.TIPOATENDIMENTO";

    private static final String QUERY_BUSCAR_TODOS_ABERTOS = "SELECT \n"
            + "	CREATEDATE AS \"Atendimento-CreateDate\",   \n"
            + "	id AS \"Atendimento-id\",   \n"
            + "	SITUACAO AS \"Atendimento-Situacao\",  \n"
            + "	T0.DESCRICAO AS \"Atendimento-Descricao\",  \n"
            + "	SOLUCAO AS \"Atendimento-Solucao\", \n"
            + "	T1.NOME AS \"Produto-Nome\",  \n"
            + "	CATEGORIA AS \"Produto-Categoria\",  \n"
            + "	T1.DESCRICAO AS \"Produto-Descricao\",  \n"
            + "	PESO AS \"Produto-Peso\", \n"
            + "	CPF AS \"Usuario-Cpf\",  \n"
            + "	T2.NOME AS \"Usuario-Nome\",\n"
            + "	EMAIl AS \"Usuario-Email\", \n"
            + "	TELEFONE AS \"Usuario-Telefone\",\n"
            + "	TIPO AS \"Usuario-Tipo\",\n"
            + "	RUA AS \"Usuario-Rua\",\n"
            + "	NUMERO AS \"Usuario-Numero\", \n"
            + "	COMPLEMENTO AS \"Usuario-Complemento\",\n"
            + "	BAIRRO AS \"Usuario-Bairro\", \n"
            + "	CEP AS \"Usuario-CEP\", \n"
            + "	CIDADE AS \"Usuario-Cidade\", \n"
            + "	ESTADO AS \"Usuario-Estado\", \n"
            + "	T3.NOME AS \"Atendimento-Nome\" \n"
            + " FROM BEIBE.Atendimento T0 INNER JOIN BEIBE.PRODUTO T1 ON T0.PRODUTO = T1.NOME INNER JOIN BEIBE.USUARIO T2 ON T0.CLIENTE = T2.CPF AND T2.TIPO = 1 \n"
            + "INNER JOIN BEIBE.TIPOATENDIMENTO T3 ON T3.NOME = T0.TIPOATENDIMENTO WHERE T0.SITUACAO = 'Aberto'";

    private static final String QUERY_BUSCAR_TODOS = "SELECT \n"
            + "	CREATEDATE AS \"Atendimento-CreateDate\",   \n"
            + "	id AS \"Atendimento-id\",   \n"
            + "	SITUACAO AS \"Atendimento-Situacao\",  \n"
            + "	T0.DESCRICAO AS \"Atendimento-Descricao\",  \n"
            + "	SOLUCAO AS \"Atendimento-Solucao\", \n"
            + "	T1.NOME AS \"Produto-Nome\",  \n"
            + "	CATEGORIA AS \"Produto-Categoria\",  \n"
            + "	T1.DESCRICAO AS \"Produto-Descricao\",  \n"
            + "	PESO AS \"Produto-Peso\", \n"
            + "	CPF AS \"Usuario-Cpf\",  \n"
            + "	T2.NOME AS \"Usuario-Nome\",\n"
            + "	EMAIl AS \"Usuario-Email\", \n"
            + "	TELEFONE AS \"Usuario-Telefone\",\n"
            + "	TIPO AS \"Usuario-Tipo\",\n"
            + "	RUA AS \"Usuario-Rua\",\n"
            + "	NUMERO AS \"Usuario-Numero\", \n"
            + "	COMPLEMENTO AS \"Usuario-Complemento\",\n"
            + "	BAIRRO AS \"Usuario-Bairro\", \n"
            + "	CEP AS \"Usuario-CEP\", \n"
            + "	CIDADE AS \"Usuario-Cidade\", \n"
            + "	ESTADO AS \"Usuario-Estado\", \n"
            + "	T3.NOME AS \"Atendimento-Nome\" \n"
            + " FROM BEIBE.Atendimento T0 INNER JOIN BEIBE.PRODUTO T1 ON T0.PRODUTO = T1.NOME INNER JOIN BEIBE.USUARIO T2 ON T0.CLIENTE = T2.CPF AND T2.TIPO = 1 \n"
            + "INNER JOIN BEIBE.TIPOATENDIMENTO T3 ON T3.NOME = T0.TIPOATENDIMENTO";

    private static final String QUERY_BUSCAR = "SELECT \n"
            + "	CREATEDATE AS \"Atendimento-CreateDate\",   \n"
            + "	id AS \"Atendimento-id\",   \n"
            + "	SITUACAO AS \"Atendimento-Situacao\",  \n"
            + "	T0.DESCRICAO AS \"Atendimento-Descricao\",  \n"
            + "	SOLUCAO AS \"Atendimento-Solucao\", \n"
            + "	T1.NOME AS \"Produto-Nome\",  \n"
            + "	CATEGORIA AS \"Produto-Categoria\",  \n"
            + "	T1.DESCRICAO AS \"Produto-Descricao\",  \n"
            + "	PESO AS \"Produto-Peso\", \n"
            + "	CPF AS \"Usuario-Cpf\",  \n"
            + "	T2.NOME AS \"Usuario-Nome\",\n"
            + "	EMAIl AS \"Usuario-Email\", \n"
            + "	TELEFONE AS \"Usuario-Telefone\",\n"
            + "	TIPO AS \"Usuario-Tipo\",\n"
            + "	RUA AS \"Usuario-Rua\",\n"
            + "	NUMERO AS \"Usuario-Numero\", \n"
            + "	COMPLEMENTO AS \"Usuario-Complemento\",\n"
            + "	BAIRRO AS \"Usuario-Bairro\", \n"
            + "	CEP AS \"Usuario-CEP\", \n"
            + "	CIDADE AS \"Usuario-Cidade\", \n"
            + "	ESTADO AS \"Usuario-Estado\", \n"
            + "	T3.NOME AS \"Atendimento-Nome\" \n"
            + " FROM BEIBE.Atendimento T0 INNER JOIN BEIBE.PRODUTO T1 ON T0.PRODUTO = T1.NOME INNER JOIN BEIBE.USUARIO T2 ON T0.CLIENTE = T2.CPF AND T2.TIPO = 1 \n"
            + "INNER JOIN BEIBE.TIPOATENDIMENTO T3 ON T3.NOME = T0.TIPOATENDIMENTO WHERE id = ?";

    private Connection con = null;

    public AtendimentoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar AtendimentoDAO.");
        }
        this.con = con;
    }

    public void inserir(Atendimento a) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR_ATENDIMENTO)) {
            st.setString(1, a.getCliente().getCpf());
            st.setString(2, "Aberto");
            st.setString(3, a.getProduto().getNome());
            st.setString(4, a.getTipoAtendimento().getNome());
            st.setString(5, a.getDescricao());
            st.setString(6, a.getSolucao());

            st.executeUpdate();

        } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e) {
            throw new DAOException("Erro ao inserir atendimento: " + e);
        } catch (SQLException e) {
            throw new DAOException(e.toString());
        }

    }

    public ArrayList<Atendimento> buscarTodosAtendimentos() {
        ArrayList<Atendimento> retorno = new ArrayList<Atendimento>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                Usuario u = new Usuario(
                        rs.getString("Usuario-Nome"),
                        rs.getString("Usuario-Cpf"),
                        rs.getString("Usuario-Email"),
                        rs.getString("Usuario-Telefone"),
                        rs.getInt("Usuario-Tipo"),
                        rs.getString("Usuario-Rua"),
                        rs.getString("Usuario-Numero"),
                        rs.getString("Usuario-Complemento"),
                        rs.getString("Usuario-Bairro"),
                        rs.getString("Usuario-CEP"),
                        rs.getString("Usuario-Cidade"),
                        rs.getString("Usuario-Estado")
                );

                Produto p = new Produto(
                        rs.getString("Produto-Nome"),
                        rs.getString("Produto-Descricao"),
                        rs.getFloat("Produto-Peso"),
                        new CategoriaProduto("Produto-Categoria")
                );

                Atendimento atendimento = new Atendimento(
                        rs.getDate("Atendimento-CreateDate"),
                        u,
                        rs.getString("Atendimento-Situacao"),
                        p,
                        rs.getString("Atendimento-Descricao"),
                        rs.getString("Atendimento-Solucao"),
                        new TipoAtendimento(rs.getString("Atendimento-Nome")),
                        rs.getInt("Atendimento-id")
                );

                retorno.add(atendimento);
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<Atendimento> buscarTodosAtendimentosAbertos() {
        ArrayList<Atendimento> retorno = new ArrayList<Atendimento>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS_ABERTOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                Usuario u = new Usuario(
                        rs.getString("Usuario-Nome"),
                        rs.getString("Usuario-Cpf"),
                        rs.getString("Usuario-Email"),
                        rs.getString("Usuario-Telefone"),
                        rs.getInt("Usuario-Tipo"),
                        rs.getString("Usuario-Rua"),
                        rs.getString("Usuario-Numero"),
                        rs.getString("Usuario-Complemento"),
                        rs.getString("Usuario-Bairro"),
                        rs.getString("Usuario-CEP"),
                        rs.getString("Usuario-Cidade"),
                        rs.getString("Usuario-Estado")
                );

                Produto p = new Produto(
                        rs.getString("Produto-Nome"),
                        rs.getString("Produto-Descricao"),
                        rs.getFloat("Produto-Peso"),
                        new CategoriaProduto("Produto-Categoria")
                );

                Atendimento atendimento = new Atendimento(
                        rs.getDate("Atendimento-CreateDate"),
                        u,
                        rs.getString("Atendimento-Situacao"),
                        p,
                        rs.getString("Atendimento-Descricao"),
                        rs.getString("Atendimento-Solucao"),
                        new TipoAtendimento(rs.getString("Atendimento-Nome")),
                        rs.getInt("Atendimento-id")
                );

                retorno.add(atendimento);
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<Atendimento> buscarTodosAtendimentoCliente(String cpf) {
        ArrayList<Atendimento> retorno = new ArrayList<Atendimento>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS_USUARIO)) {
            st.setString(1, cpf);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                Usuario u = new Usuario(
                        rs.getString("Usuario-Nome"),
                        rs.getString("Usuario-Cpf"),
                        rs.getString("Usuario-Email"),
                        rs.getString("Usuario-Telefone"),
                        rs.getInt("Usuario-Tipo"),
                        rs.getString("Usuario-Rua"),
                        rs.getString("Usuario-Numero"),
                        rs.getString("Usuario-Complemento"),
                        rs.getString("Usuario-Bairro"),
                        rs.getString("Usuario-CEP"),
                        rs.getString("Usuario-Cidade"),
                        rs.getString("Usuario-Estado")
                );

                Produto p = new Produto(
                        rs.getString("Produto-Nome"),
                        rs.getString("Produto-Descricao"),
                        rs.getFloat("Produto-Peso"),
                        new CategoriaProduto("Produto-Categoria")
                );

                Atendimento atendimento = new Atendimento(
                        rs.getDate("Atendimento-CreateDate"),
                        u,
                        rs.getString("Atendimento-Situacao"),
                        p,
                        rs.getString("Atendimento-Descricao"),
                        rs.getString("Atendimento-Solucao"),
                        new TipoAtendimento(rs.getString("Atendimento-Nome")),
                        rs.getInt("Atendimento-id")
                );

                retorno.add(atendimento);
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }

    public Atendimento buscarAtendimento(int index) {
        Atendimento retorno = new Atendimento();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, index);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                Usuario u = new Usuario(
                        rs.getString("Usuario-Nome"),
                        rs.getString("Usuario-Cpf"),
                        rs.getString("Usuario-Email"),
                        rs.getString("Usuario-Telefone"),
                        rs.getInt("Usuario-Tipo"),
                        rs.getString("Usuario-Rua"),
                        rs.getString("Usuario-Numero"),
                        rs.getString("Usuario-Complemento"),
                        rs.getString("Usuario-Bairro"),
                        rs.getString("Usuario-CEP"),
                        rs.getString("Usuario-Cidade"),
                        rs.getString("Usuario-Estado")
                );

                Produto p = new Produto(
                        rs.getString("Produto-Nome"),
                        rs.getString("Produto-Descricao"),
                        rs.getFloat("Produto-Peso"),
                        new CategoriaProduto("Produto-Categoria")
                );

                Atendimento atendimento = new Atendimento(
                        rs.getDate("Atendimento-CreateDate"),
                        u,
                        rs.getString("Atendimento-Situacao"),
                        p,
                        rs.getString("Atendimento-Descricao"),
                        rs.getString("Atendimento-Solucao"),
                        new TipoAtendimento(rs.getString("Atendimento-Nome")),
                        rs.getInt("Atendimento-id")
                );

                retorno = atendimento;
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }

    public String deletarAtendimento(int index) {
        try (PreparedStatement st = con.prepareStatement(QUERY_DELETAR_ATENDIMENTO)) {
            st.setInt(1, index);
            int i = st.executeUpdate();
            if (i > 0){
                return "Atendimento deletado";
            }else{
                return "Erro ao deletar atendimento. (Atendimento já finalizado)";
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public void AtenderAtendimento(int index, String solucacao) {
        try (PreparedStatement st = con.prepareStatement(QUERY_ATENDER_ATENDIMENTO)) {
            st.setString(1, solucacao);
            st.setInt(2, index);
            int i = st.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
}
