package org.ludo.bibliotheque.entities;

import com.fasterxml.jackson.annotation.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
public class Livre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLivre ;
    private String titre ;
    private String auteur ;
    private String editeur ;
    private String decription ;
    private String isbn ;
    private int nombrePages ;
    private int quantiteDispo ;
    private String urlImage ;

    @JsonIgnore
    @OneToMany(mappedBy = "livre", fetch = FetchType.LAZY)
    private Set<Emprunt> emprunt;

    public Livre() {
        super();
    }

    public Livre(Long idLivre, String titre, String auteur, String editeur, String decription, String isbn, int nombrePages, int quantiteDispo, Set<Emprunt> emprunt, String urlImage) {
        this.idLivre = idLivre;
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.decription = decription;
        this.isbn = isbn;
        this.nombrePages = nombrePages;
        this.quantiteDispo = quantiteDispo;
        this.emprunt = emprunt;
        this.urlImage = urlImage;
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
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public int getQuantiteDispo() {
        return quantiteDispo;
    }

    public void setQuantiteDispo(int quantiteDispo) {
        this.quantiteDispo = quantiteDispo;
    }

    public Set<Emprunt> getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Set<Emprunt> emprunt) {
        this.emprunt = emprunt;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
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
                ", nombrePages=" + nombrePages +
                ", quantiteDispo=" + quantiteDispo +
                ", urlImage='" + urlImage + '\'' +
                ", emprunt=" + emprunt +
                '}';
    }
}
