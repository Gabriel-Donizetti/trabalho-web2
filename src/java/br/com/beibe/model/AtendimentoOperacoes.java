/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.model;

import br.com.beibe.beans.Atendimento;
import br.com.beibe.beans.TipoAtendimento;
import br.com.beibe.beans.Usuario;
import br.com.beibe.dao.AtendimentoDAO;
import br.com.beibe.dao.ConnectionFactory;
import br.com.beibe.exception.DAOException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Kulka
 */
public class AtendimentoOperacoes {

    public static Atendimento InserirAtendimento(Atendimento a) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            AtendimentoDAO dao = new AtendimentoDAO(factory.getConnection());
            dao.inserir(a);
            return a;
        } catch (Exception ex) {
            throw new DAOException("Não foi possivel inserir atendimento. " + ex);
        }
    }

    public static Atendimento gerarBeanAtendimento(Usuario u, String produto, String desc, String atendimentoTipo) throws DAOException {
        try {
            Atendimento a = new Atendimento(u, "Aberto", ProdutoModel.BuscarProduto(produto), desc, "", new TipoAtendimento(atendimentoTipo));
            return a;
        } catch (DAOException exc) {
            throw new DAOException("Erro ao gerar atendimento: " + exc);
        }
    }

    public static ArrayList<Atendimento> ListarAtendimentos(String user) throws DAOException {
        ArrayList<Atendimento> retorno = new ArrayList<Atendimento>();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            AtendimentoDAO dao = new AtendimentoDAO(factory.getConnection());
            retorno = dao.buscarTodosAtendimentoCliente(user);
        } catch (Exception exc) {
            throw new DAOException("Erro ao listar atendimentos: " + exc);
        }
        return retorno;
    }

    public static ArrayList<Atendimento> ListarTodosAtendimentos() throws DAOException {
        ArrayList<Atendimento> retorno = new ArrayList<Atendimento>();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            AtendimentoDAO dao = new AtendimentoDAO(factory.getConnection());
            retorno = dao.buscarTodosAtendimentos();
        } catch (Exception exc) {
            throw new DAOException("Erro ao listar atendimentos: " + exc);
        }
        return retorno;
    }

    public static ArrayList<Atendimento> ListarTodosAtendimentosAbertos() throws DAOException {
        ArrayList<Atendimento> retorno = new ArrayList<Atendimento>();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            AtendimentoDAO dao = new AtendimentoDAO(factory.getConnection());
            retorno = dao.buscarTodosAtendimentosAbertos();
        } catch (Exception exc) {
            throw new DAOException("Erro ao listar atendimentos: " + exc);
        }
        return retorno;
    }

    public static Atendimento buscarAtendimento(int index) throws DAOException {
        Atendimento retorno = new Atendimento();
        try (ConnectionFactory factory = new ConnectionFactory()) {
            AtendimentoDAO dao = new AtendimentoDAO(factory.getConnection());
            retorno = dao.buscarAtendimento(index);
        } catch (Exception exc) {
            throw new DAOException("Erro ao busar atendimento: " + exc);
        }
        return retorno;
    }

    public static String deletarAtendimento(int index) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            AtendimentoDAO dao = new AtendimentoDAO(factory.getConnection());
            return dao.deletarAtendimento(index);
        } catch (Exception exc) {
            throw new DAOException("Erro ao busar atendimento: " + exc);
        }
    }

}
