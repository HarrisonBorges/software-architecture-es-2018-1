package com.mycompany.mavenproject1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Factory {
    private static Connection instance;
    private String dbURL = "jdbc:mysql://localhost:3306/saapp?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private String username = "root";
    private String password = "root";
    
    
    private Factory(){
        try {
            instance = DriverManager.getConnection(this.dbURL, this.username, this.password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao se Conectar ao Banco de Dados: \n" + ex.getMessage()); // Mensagem de ERRO
        }
    }
    
    public static synchronized Connection getInstance(){
        if(instance == null)
            new Factory();
        return instance;
    }
}
