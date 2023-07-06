/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoding.bank.entities;

import com.summercoding.bank.utils.JDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ETHAN BOY
 */
public class Utilisateur {

    int iduser;

    String login;

    String password;

    String nom;

    String prenom;

    LocalDate datenaiss;

    String genre;

    int idadmin;
    public String getLogin;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    @SuppressWarnings("null")
    public void save(String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) throws SQLException {

        String command = "INSERT INTO `utilisateur` (`login`, `password`, `nom`, `prenom`, `datenaiss`, `genre`, `idadmin`) VALUES(?,?,?,?,?,?,?)";

        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);

        addstmt.setObject(1, login);
        addstmt.setObject(2, password);
        addstmt.setObject(3, nom);
        addstmt.setObject(4, prenom);
        addstmt.setObject(5, datenaiss);
        addstmt.setObject(6, genre);
        addstmt.setObject(7, idadmin);
        addstmt.execute();

    }

    public void update(int iduser, String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) throws SQLException {

        String command = "UPDATE `utilisateur` SET `login` = ?, `password` = ?, `nom` = ?`prenom` = ?, `datenaiss` = ?, `genre` = ?, `idadmin` = ? WHERE `utilisateur`.`iduser` = ?";

        PreparedStatement addstmt;
        addstmt = JDBC.getConnexion().prepareStatement(command);

        addstmt.setObject(1, login);
        addstmt.setObject(2, password);
        addstmt.setObject(3, nom);
        addstmt.setObject(4, prenom);
        addstmt.setObject(5, datenaiss);
        addstmt.setObject(6, genre);
        addstmt.setObject(7, idadmin);
        addstmt.execute();
    }

    public void delate(int iduser) throws SQLException {

        String command = "DELETE FROM `utilisateur` WHERE `utilisateur`.`iduser` = ?";

        PreparedStatement addstmt;
        addstmt = JDBC.getConnexion().prepareStatement(command);

        addstmt.setObject(1, login);
        addstmt.setObject(2, password);
        addstmt.setObject(3, nom);
        addstmt.setObject(4, prenom);
        addstmt.setObject(5, datenaiss);
        addstmt.setObject(6, genre);
        addstmt.setObject(7, idadmin);
        addstmt.execute();
    }

    public Utilisateur getOne(int iduser) throws SQLException {

        String cmd = "select * from utilisateur where iduser = ?";

        PreparedStatement stmt
                = JDBC.getConnexion().prepareStatement(cmd);

        stmt.setObject(1, iduser);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            return new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getDate(6).toLocalDate(), rs.getString(7), rs.getInt(8));
        }
        return null;
    }

    public List<Utilisateur> getAllUtilisateur() throws SQLException {

        String cmd = "select * from utilisateur";

        PreparedStatement stmt
                = JDBC.getConnexion().prepareStatement(cmd);

        ResultSet rs = stmt.executeQuery();

        List<Utilisateur> listUtilisateur = new ArrayList<>();

        while (rs.next()) {

            listUtilisateur.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getDate(6).toLocalDate(), rs.getString(7), rs.getInt(8)));
        }
        return listUtilisateur;
    }

    public Utilisateur getByLoginAndpassword(String login, String password) throws SQLException {

        String cmd = "select * from admin where login = ? and password = ?";

        PreparedStatement stmt
                = JDBC.getConnexion().prepareStatement(cmd);

        stmt.setObject(1, login);
        stmt.setObject(2, password);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            return new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getDate(6).toLocalDate(), rs.getString(7), rs.getInt(8));
        }
        return null;
    }

    public Utilisateur() {
    }

    public Utilisateur(int iduser, String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, int idadmin) {
        this.iduser = iduser;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.genre = genre;
        this.idadmin = idadmin;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "iduser=" + iduser + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", datenaiss=" + datenaiss + ", genre=" + genre + ", idadmin=" + idadmin + '}';
    }

    public static void main(String arg[]) {

        try {
            Utilisateur utilisateur = new Utilisateur();
            //utilisateur.save("tom","tom","tom","eli",LocalDate.of(2002,Month.JUNE,21),"homme",3);
            String result = utilisateur.getAllUtilisateur().toString();
            System.out.println(result);

        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(String login, String password, String nom, String prenom, LocalDate datenaiss, String genre, String idadmin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAllIduser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
