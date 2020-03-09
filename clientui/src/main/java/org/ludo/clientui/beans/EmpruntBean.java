package org.ludo.clientui.beans;

import java.util.Date;

public class EmpruntBean {

        private Long emprunt ;
        private Date dateDebut ;
        private Date dateFin ;
        private boolean prolongeable ;

        public EmpruntBean(Date dateDebut, Date dateFin, boolean prolongeable) {
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
