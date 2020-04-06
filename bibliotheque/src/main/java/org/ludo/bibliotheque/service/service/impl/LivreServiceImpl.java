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

        nouveauLivre.setAuteur(livre.getAuteur());
        nouveauLivre.setDecription(livre.getDecription());
        nouveauLivre.setEditeur(livre.getEditeur());
        nouveauLivre.setIsbn(livre.getIsbn());
        nouveauLivre.setNombrePages(livre.getNombrePages());
        nouveauLivre.setQuantiteDispo(livre.getQuantiteDispo());
        nouveauLivre.setTitre(livre.getTitre());
        nouveauLivre.setUrlImage(livre.getUrlImage());

        return livreRepository.save(nouveauLivre);
    }


    @Override
    public void supprimerLivre(Long idLivre) {
        livreRepository.deleteById(idLivre);
    }
}
