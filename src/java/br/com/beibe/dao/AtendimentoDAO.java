/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.dao;

import br.com.beibe.beans.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.beibe.exception.DAOException;
/**
 *
 * @author Rafael Kulka
 */
public class AtendimentoDAO {
    private static final String QUERY_INSERIR_ATENDIMENTO = "INSERT INTO BEIBE.Atendimento (CreateDate, Cliente, Situacao, Produto, TipoAtendimento, Descricao, Solucao) VALUES (NOW(),?,?,?, ? ,?,?)";
    //private static final String QUERY_BUSCAR = "SELECT * FROM BEIBE.usuario WHERE email = ? AND senha = CAST(HASH('MD5', ?) AS VARCHAR)";
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
             

        } catch(org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e){
            throw new DAOException("Erro ao inserir atendimento: " + e);
        }
        catch (SQLException e) {
            throw new DAOException( e.toString());
        }

    }

   /* public Atendimento buscarUser(String email, String senha) {
        
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

    }*/

    
}
