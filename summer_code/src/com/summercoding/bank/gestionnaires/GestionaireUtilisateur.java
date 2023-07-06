/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.gestionnaires;

import com.summercoding.bank.controlleur.Controlleur;
import com.summercoding.bank.entities.Utilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ETHAN BOY
 */
public class GestionaireUtilisateur {
    
   
       Utilisateur utilisateur = new Utilisateur();  
           
          public void saveUtilisateur(String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) throws SQLException{
              
              utilisateur.save(login, password, nom, prenom, datenaiss, genre, idadmin);
          
    }
          
            public List<Utilisateur> ListAllUtilisateur() throws SQLException {
                 return utilisateur.getAllUtilisateur();
            }

   

    
}
