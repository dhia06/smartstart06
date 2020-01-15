/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author bhk
 */
public class Task {

    private String username;
    private String email;
    private String nom;
    private String prenom;
    private String role;
    private String password;

    public Task(String username, String email, String nom, String prenom, String role, String password) {
        this.username = username;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.password = password;
    }

    public Task() {
       
    }

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Task{" + "username=" + username + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", password=" + password + '}';
    }

}
