package org.ludo.bibliotheque.service.service.impl;

import org.ludo.bibliotheque.dao.EmpruntRepository;
import org.ludo.bibliotheque.dto.EmpruntDto;
import org.ludo.bibliotheque.entities.Emprunt;
import org.ludo.bibliotheque.entities.Livre;
import org.ludo.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    @Autowired
    EmpruntRepository empruntRepository ;

    @Override
    public List<Emprunt> findAll() {
        return empruntRepository.findAll();
    }

    @Override
    public Optional<Emprunt> findById(Long idEmprunt) {
        return empruntRepository.findById(idEmprunt);
    }

    @Override
    public List<Emprunt> findAllByIdUtilisateur(Long idUtilisateur) {
        return empruntRepository.findAllByIdUtilisateur(idUtilisateur);
    }

    @Override
    public Emprunt ouvrirEmprunt(EmpruntDto empruntDto, Livre livre) {

        Emprunt nouvelEmprunt = new Emprunt();

        nouvelEmprunt.setDateDebut(empruntDto.getDateDebut());
        nouvelEmprunt.setDateFin(empruntDto.getDateFin());
        nouvelEmprunt.setProlongeable(empruntDto.isProlongeable());
        nouvelEmprunt.setIdUtilisateur(empruntDto.getIdUtilisateur());
        nouvelEmprunt.setLivre(livre);
        nouvelEmprunt.setEnCours(true);

        return empruntRepository.save(nouvelEmprunt);
    }

    @Override
    public Emprunt cloturerEmprunt(Long idEmprunt) {
        Emprunt emprunt = empruntRepository.findById(idEmprunt).get();
        Date date = new Date();

        emprunt.setEnCours(false);
        emprunt.setDateFin(date);

        return empruntRepository.save(emprunt);
    }


}
