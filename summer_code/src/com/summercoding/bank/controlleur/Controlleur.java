/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.controlleur;

import com.summercoding.bank.entities.Admin;
import com.summercoding.bank.entities.Utilisateur;
import com.summercoding.bank.gestionnaires.GestionaireAdmin;
import com.summercoding.bank.gestionnaires.GestionaireCompte;
import com.summercoding.bank.gestionnaires.GestionaireUtilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ETHAN BOY
 */
public class Controlleur {

    GestionaireAdmin gestionaireAdmin = new GestionaireAdmin();

    GestionaireCompte gestionaireCompte = new GestionaireCompte();

    public Admin routeVersLogin(String login, String password) throws SQLException {

        return gestionaireAdmin.login(login, password);
    }

    public void routeVersaveAdmin(String login, String password, String nom) throws SQLException {

        gestionaireAdmin.saveAdmin(login, password, nom);
    }

    
    public void routeVerupdateAdmin(int idadmin, String login, String password, String nom) throws SQLException {

        gestionaireAdmin.updateAdmin(idadmin, login, password, nom);
    }

      
    public void routeVerdelateAdmin(int idadmin) throws SQLException {

        gestionaireAdmin.delateAdmin(idadmin);
    }

    GestionaireUtilisateur gestionaireUtilisateur = new GestionaireUtilisateur();

    public void routeVersaveUtilisateur(String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) throws SQLException {

        gestionaireUtilisateur.saveUtilisateur(login, password, nom, prenom, datenaiss, genre, idadmin);
    }

    public void routeVersaveCompte(double solde, int iduser, int idadmin) throws SQLException {

        gestionaireCompte.saveCompte(solde, iduser, idadmin);
    }

    public List<Admin> routeVerlistAllAdmin() throws SQLException {
        return gestionaireAdmin.listAllAdmin();
    }

    public List<Utilisateur> routeVerlistAllUtilisateur() throws SQLException {
        return gestionaireUtilisateur.ListAllUtilisateur();
    }

        
    public Admin routeVergetAdminDetails(int idadmin) throws SQLException{
    
        return gestionaireAdmin.getAdminDetails(idadmin);
    }
}
