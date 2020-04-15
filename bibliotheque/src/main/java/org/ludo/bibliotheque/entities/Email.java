package org.ludo.bibliotheque.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMail ;

    private String nom ;

    private String objet ;

    private String contenu ;

    public Email() {
    }

    public Email(Long idMail, String nom, String objet, String contenu) {
        this.idMail = idMail;
        this.nom = nom;
        this.objet = objet;
        this.contenu = contenu;
    }

    public Long getIdMail() {
        return idMail;
    }

    public void setIdMail(Long idMail) {
        this.idMail = idMail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "email{" +
                "idMail=" + idMail +
                ", nom='" + nom + '\'' +
                ", objet='" + objet + '\'' +
                ", contenu='" + contenu + '\'' +
                '}';
    }
}
