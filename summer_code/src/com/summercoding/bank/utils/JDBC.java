/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ETHAN BOY
 */
public class JDBC {
    
private final static String URL = "jdbc:mysql://localhost:3306/summerbankdb";

private final static String USER = "root";

private final static String PASSWORD = "";


public static Connection getConnexion(){

    try {
        Connection connexion;
        connexion = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        try {
            return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}


}