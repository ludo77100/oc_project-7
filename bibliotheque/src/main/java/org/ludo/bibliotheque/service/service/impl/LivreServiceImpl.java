package org.ludo.bibliotheque.service.service.impl;

import org.ludo.bibliotheque.dao.LivreRepository;
import org.ludo.bibliotheque.entities.Livre;
import org.ludo.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    @Autowired
    LivreRepository livreRepository ;

    @Override
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    @Override
    public List<Livre> findByTitreContainingIgnoreCase(String mc) {
        return livreRepository.findByTitreContainingIgnoreCase(mc);
    }

    @Override
    public Livre enregistrerNouveauLivre(Livre livre) {

        Livre nouveauLivre = new Livre() ;

        nouveauLivre.getAuteur();
        nouveauLivre.getDecription();
        nouveauLivre.getEditeur();
        nouveauLivre.getIsbn();
        nouveauLivre.getNombrePages();
        nouveauLivre.getQuantiteDispo();
        nouveauLivre.getTitre();

        return livreRepository.save(nouveauLivre);
    }


    @Override
    public void supprimerLivre(Long idLivre) {
        livreRepository.deleteById(idLivre);
    }
}
