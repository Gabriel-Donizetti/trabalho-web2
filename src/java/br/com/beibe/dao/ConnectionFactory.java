/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.com.beibe.exception.DAOException;

/**
 *
 * @author Rafael Kulka
 */
public class ConnectionFactory implements AutoCloseable {

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String LOGIN = "sa";
    private static final String SENHA = "";

    private Connection con = null;

    public Connection getConnection() throws DAOException  {
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, LOGIN, SENHA);
            } catch (ClassNotFoundException e) {
               throw new DAOException("Driver do banco não encontrado: " + DRIVER, e);
            } catch (SQLException e) {
                throw new DAOException("Erro conectando ao BD: " + URL + "/" + LOGIN + "/" + SENHA, e);
            }
        }
        return con;
    }

    @Override
    public void close() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (Exception e) {
                System.out.println("Erro fechando a conexão. IGNORADO");
                e.printStackTrace();
            }
        }
    }
    
}
