/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.gestionnaires;

import com.summercoding.bank.entities.Admin;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ETHAN BOY
 */
public class GestionaireAdmin {

    Admin admin = new Admin();

    public Admin login(String login, String password) throws SQLException {

        return admin.getByLoginAndPassword(login, password);
    }

    public void saveAdmin(String login, String password, String nom) throws SQLException {

        admin.save(login, password, nom);
    }

    public List<Admin> listAllAdmin() throws SQLException {
        return admin.getAllAdmin();
    }
}
