package org.ludo.bibliotheque.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLivre ;
    private String titre ;
    private String auteur ;
    private String editeur ;
    private String decription ;
    private String isbn ;
    private int NombrePages ;
    private int quantiteDispo ;

    @NonNull
    @JsonManagedReference
    @OneToMany(mappedBy = "idEmprunt", fetch = FetchType.EAGER)
    private Collection<Emprunt> emprunt;

    public Livre() {
    }

    public Livre(Long idLivre, String titre, String auteur, String editeur, String decription, String isbn, int nombrePages, int quantiteDispo, Collection<Emprunt> emprunt) {
        this.idLivre = idLivre;
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.decription = decription;
        this.isbn = isbn;
        NombrePages = nombrePages;
        this.quantiteDispo = quantiteDispo;
        this.emprunt = emprunt;
    }

    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Long idLivre) {
        this.idLivre = idLivre;
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

    public Collection<Emprunt> getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Collection<Emprunt> emprunt) {
        this.emprunt = emprunt;
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
                ", emprunt=" + emprunt +
                '}';
    }
}
