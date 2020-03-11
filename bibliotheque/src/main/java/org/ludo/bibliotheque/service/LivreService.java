package org.ludo.bibliotheque.service;

import org.ludo.bibliotheque.dto.LivreDto;
import org.ludo.bibliotheque.entities.Livre;

import java.util.List;

public interface LivreService {

    List<Livre> findAll();

    List<Livre> findByTitreContainingIgnoreCase(String mc);

    Livre enregistrerNouveauLivre(LivreDto livreDto);

    Livre editionLivre(LivreDto livreEditionDto);

    void supprimerLivre(Long livre);
}
