package org.ludo.bibliotheque.entities;

import sun.java2d.loops.GeneralRenderer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emprunt ;
    private Date dateDebut ;
    private Date dateFin ;
    private boolean prolongeable ;

    public Emprunt() {
    }

    public Emprunt(Date dateDebut, Date dateFin, boolean prolongeable) {
        this.dateFin = dateFin ;
        this.dateDebut = dateDebut ;
        this.prolongeable = prolongeable ;
    }

    public Long getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Long emprunt) {
        this.emprunt = emprunt;
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

    @Override
    public String toString() {
        return "Emprunt{" +
                "emprunt=" + emprunt +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", prolongeable=" + prolongeable +
                '}';
    }
}
