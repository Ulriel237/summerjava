/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.gestionnaires;

import com.summercoding.bank.entities.Compte;
import java.sql.SQLException;

/**
 *
 * @author ETHAN BOY
 */
public class GestionaireCompte {
    
    Compte compte = new Compte();
   
     
     public void saveCompte(double solde, int iduser, int idadmin) throws SQLException{
        
        compte.save(solde, iduser, idadmin);
    }
 
    
}
