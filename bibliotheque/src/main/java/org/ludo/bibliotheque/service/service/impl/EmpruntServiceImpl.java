package org.ludo.bibliotheque.service.service.impl;

import org.ludo.bibliotheque.dao.EmpruntRepository;
import org.ludo.bibliotheque.dao.LivreRepository;
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
    @Autowired
    LivreRepository livreRepository ;

    @Override
    public List<Emprunt> findAll() {
        return empruntRepository.findAll();
    }

    @Override
    public Optional<Emprunt> findById(Long idEmprunt) {
        return empruntRepository.findById(idEmprunt);
    }

    @Override
    public List<Emprunt> findAllByPseudoEmprunteur(String pseudoEmprunteur) {
        return empruntRepository.findAllByPseudoEmprunteur(pseudoEmprunteur);
    }

    @Override
    public Emprunt ouvrirEmprunt(Emprunt emprunt, Long idLivre) {

        Emprunt nouvelEmprunt = new Emprunt();
        Livre livre = livreRepository.findById(idLivre).get();

        nouvelEmprunt.getDateDebut();
        nouvelEmprunt.getDateFin();
        nouvelEmprunt.isProlongeable();
        nouvelEmprunt.getPseudoEmprunteur();
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
