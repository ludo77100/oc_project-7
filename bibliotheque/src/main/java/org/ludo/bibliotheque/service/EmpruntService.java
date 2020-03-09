package org.ludo.bibliotheque.service;

import org.ludo.bibliotheque.dto.EmpruntDto;
import org.ludo.bibliotheque.entities.Emprunt;

import java.util.List;
import java.util.Optional;

public interface EmpruntService {

    List<Emprunt> findAll();

    Optional<Emprunt> findById(Long idEmprunt);

    Emprunt ouvrirEmprunt(EmpruntDto empruntDto);


}
