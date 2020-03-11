package org.ludo.bibliotheque.dto;

import java.util.Date;

public class EmpruntDto {

    private Long idUtilisateur ;
    private Date dateDebut ;
    private Date dateFin ;
    private boolean prolongeable ;

    public EmpruntDto(Long idUtilisateur, Date dateDebut, Date dateFin, boolean prolongeable) {
        this.idUtilisateur = idUtilisateur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prolongeable = prolongeable;
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

    @Override
    public String toString() {
        return "EmpruntDto{" +
                "idUtilisateur=" + idUtilisateur +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", prolongeable=" + prolongeable +
                '}';
    }
}