package org.ludo.bibliotheque.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmprunt;
    private Long idUtilisateur ;
    private Date dateDebut;
    private Date dateFin;
    private boolean prolongeable;
    private boolean enCours ;

    @NonNull
    @ManyToOne
   @JsonManagedReference
    private Livre livre ;

    public Emprunt() {
    }

    public Emprunt(Long idEmprunt, Long idUtilisateur, Date dateDebut, Date dateFin, boolean prolongeable, boolean enCours, Livre livre) {
        this.idEmprunt = idEmprunt;
        this.idUtilisateur = idUtilisateur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prolongeable = prolongeable;
        this.livre = livre;
        this.enCours = enCours ;
    }

    public Long getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(Long idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isProlongeable() {
        return prolongeable;
    }

    public void setProlongeable(boolean prolongeable) {
        this.prolongeable = prolongeable;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public boolean isEnCours(boolean b) {
        return enCours;
    }

    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "idEmprunt=" + idEmprunt +
                ", idUtilisateur=" + idUtilisateur +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", prolongeable=" + prolongeable +
                ", enCours=" + enCours +
                ", livre=" + livre +
                '}';
    }
}