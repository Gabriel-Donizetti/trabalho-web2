/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.model;


import br.com.beibe.beans.Atendimento;
import br.com.beibe.dao.AtendimentoDAO;
import br.com.beibe.dao.ConnectionFactory;
import br.com.beibe.exception.DAOException;

/**
 *
 * @author Rafael Kulka
 */
public class AtendimentoOperacoes {
    public static Atendimento InserirAtendimento(Atendimento a) throws DAOException  {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            AtendimentoDAO dao = new AtendimentoDAO(factory.getConnection());
            dao.inserir(a);
            return a;
        } catch (Exception ex) {
            throw new DAOException("Não foi possivel inserir atendimento. " + ex);
        }
    }
}
