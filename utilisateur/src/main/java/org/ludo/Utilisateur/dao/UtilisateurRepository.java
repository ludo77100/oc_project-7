package org.ludo.Utilisateur.dao;

import org.ludo.Utilisateur.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByPseudo(String pseudo);


}
