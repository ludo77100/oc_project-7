package org.ludo.Utilisateur.entities;

import org.ludo.Utilisateur.emums.RoleEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue
    private int idUtilisateur ;
    private String pseudo;
    private String motDePass;
    private String email;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<RoleEnum> userRoleList;

    public Utilisateur() {
    }

    public Utilisateur(int idUtilisateur, String pseudo, String motDePass, String email) {
        this.idUtilisateur = idUtilisateur ;
        this.pseudo = pseudo ;
        this.motDePass = motDePass ;
        this.email = email ;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public void setMotDePass(String motDePass) {
        this.motDePass = motDePass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void grantAuthority(RoleEnum authority) {
        if (userRoleList == null) userRoleList = new ArrayList<>();
        userRoleList.add(authority);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", pseudo='" + pseudo + '\'' +
                ", motDePass='" + motDePass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
