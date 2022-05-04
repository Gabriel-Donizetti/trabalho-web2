/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.model;

import br.com.beibe.dao.ConnectionFactory;
import br.com.beibe.exception.DAOException;
/**
 *
 * @author Iury
 */
public class RelatorioOperacoes {
        
    
    public  RelatorioOperacoes( ) throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
        }
}
}