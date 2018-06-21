/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art.creativity.entities;

import java.io.Serializable;

/**
 *
 * @author Geraud
 */
public class ABSearch implements Serializable{
    private Long numeroAB;
    private String nom;
    private String prenom;

    public ABSearch() {
    }

    public ABSearch(Long numeroAB, String nom, String prenom) {
        this.numeroAB = numeroAB;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getNumeroAB() {
        return numeroAB;
    }

    public void setNumeroAB(Long numeroAB) {
        this.numeroAB = numeroAB;
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
    
}
