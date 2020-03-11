package org.ludo.bibliotheque.service;

import org.ludo.bibliotheque.dto.EmpruntDto;
import org.ludo.bibliotheque.entities.Emprunt;
import org.ludo.bibliotheque.entities.Livre;

import java.util.List;
import java.util.Optional;

public interface EmpruntService {

    List<Emprunt> findAll();

    Optional<Emprunt> findById(Long idEmprunt);

    List<Emprunt> findAllByIdUtilisateur(Long idUtilisateur);

    Emprunt ouvrirEmprunt(EmpruntDto empruntDto, Livre livre);

    Emprunt cloturerEmprunt(Long idEmprunt);
}
