package org.ludo.bibliotheque.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLivre ;
    private String titre ;
    private String auteur ;
    private String editeur ;
    private String decription ;
    private String isbn ;
    private int NombrePages ;
    private int quantiteDispo ;

    public Livre(){
    }

    public Livre(String titre, String auteur, String editeur, String decription, String isbn, int nombrePages, int quantiteDispo) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.decription = decription;
        this.isbn = isbn;
        NombrePages = nombrePages;
        this.quantiteDispo = quantiteDispo;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNombrePages() {
        return NombrePages;
    }

    public void setNombrePages(int nombrePages) {
        NombrePages = nombrePages;
    }

    public int getQuantiteDispo() {
        return quantiteDispo;
    }

    public void setQuantiteDispo(int quantiteDispo) {
        this.quantiteDispo = quantiteDispo;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "idLivre=" + idLivre +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", decription='" + decription + '\'' +
                ", isbn='" + isbn + '\'' +
                ", NombrePages=" + NombrePages +
                ", quantiteDispo=" + quantiteDispo +
                '}';
    }
}
