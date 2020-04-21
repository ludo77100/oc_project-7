package org.ludo.bibliotheque.dao;

import org.ludo.bibliotheque.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

    List<Emprunt> findAllByPseudoEmprunteurAndEnCoursIsTrue(String pseudoEmprunteur);

    List<Emprunt> findAllByEnCoursFalseAndDateFinBefore(Date dateDuJour);
}
