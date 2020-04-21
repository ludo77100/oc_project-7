package org.ludo.bibliotheque.service.service.impl;

import org.ludo.bibliotheque.dao.EmpruntRepository;
import org.ludo.bibliotheque.dao.LivreRepository;
import org.ludo.bibliotheque.entities.Emprunt;
import org.ludo.bibliotheque.entities.Livre;
import org.ludo.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
        return empruntRepository.findAllByPseudoEmprunteurAndEnCoursIsTrue(pseudoEmprunteur);
    }

    @Override
    public Date ajouter4Semaines(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 28);
        return calendar.getTime();
    }

    @Override
    public Emprunt prolongerEmprunt(Long idEmprunt) {

        Emprunt emprunt = empruntRepository.findById(idEmprunt).get();

        Date dateDebut = emprunt.getDateFin();

        if (emprunt.isProlongeable() == true && emprunt.isEnCours() == true) {
            emprunt.setDateFin(ajouter4Semaines(dateDebut));
            emprunt.setProlongeable(false);
        } else {
            return null ;
        }
        return empruntRepository.save(emprunt);
    }

    @Override
    public List<Emprunt> listeLivreNonRendueApresDateFin() {
        Date dateDuJour = new Date();
        List<Emprunt> listeEmprunt = empruntRepository.findAllByEnCoursFalseAndDateFinBefore(dateDuJour);
        return listeEmprunt;
    }

    @Override
    public Emprunt ouvrirEmprunt(Long idLivre, String pseudoEmprunteur) {

        Emprunt nouvelEmprunt = new Emprunt();
        Livre livre = livreRepository.findById(idLivre).get();
        Date date = new Date();

        nouvelEmprunt.setDateDebut(date);
        nouvelEmprunt.setDateFin(ajouter4Semaines(date));
        nouvelEmprunt.setPseudoEmprunteur(pseudoEmprunteur);
        nouvelEmprunt.setLivre(livre);
        nouvelEmprunt.setEnCours(true);
        nouvelEmprunt.setProlongeable(true);

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
