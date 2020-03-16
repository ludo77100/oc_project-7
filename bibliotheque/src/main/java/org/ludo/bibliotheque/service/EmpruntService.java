package org.ludo.bibliotheque.service;


import org.ludo.bibliotheque.entities.Emprunt;
import org.ludo.bibliotheque.entities.Livre;

import java.util.List;
import java.util.Optional;

public interface EmpruntService {

    List<Emprunt> findAll();

    Optional<Emprunt> findById(Long idEmprunt);

    List<Emprunt> findAllByPseudoEmprunteur(String pseudoEmprunteur);

    Emprunt ouvrirEmprunt(Emprunt emprunt, Long idLivre);

    Emprunt cloturerEmprunt(Long idEmprunt);
}
