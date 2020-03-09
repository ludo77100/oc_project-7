package org.ludo.bibliotheque.service.service.impl;

import org.ludo.bibliotheque.dao.LivreRepository;
import org.ludo.bibliotheque.dto.LivreDto;
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
    public Livre enregistrerNouveauLivre(LivreDto livreDto) {

        Livre nouveauLivre = new Livre() ;

        nouveauLivre.setAuteur(livreDto.getAuteur());
        nouveauLivre.setDecription(livreDto.getDecription());
        nouveauLivre.setEditeur(livreDto.getEditeur());
        nouveauLivre.setIsbn(livreDto.getIsbn());
        nouveauLivre.setNombrePages(livreDto.getNombrePages());
        nouveauLivre.setQuantiteDispo(livreDto.getQuantiteDispo());
        nouveauLivre.setTitre(livreDto.getTitre());

        return livreRepository.save(nouveauLivre);
    }

    @Override
    public Livre editionLivre(LivreDto livreEditionDto) {

        Livre modificationLivre = livreRepository.findByTitre(livreEditionDto.getTitre());

        modificationLivre.setAuteur(livreEditionDto.getAuteur());
        modificationLivre.setDecription(livreEditionDto.getDecription());
        modificationLivre.setEditeur(livreEditionDto.getEditeur());
        modificationLivre.setIsbn(livreEditionDto.getIsbn());
        modificationLivre.setNombrePages(livreEditionDto.getNombrePages());
        modificationLivre.setQuantiteDispo(livreEditionDto.getQuantiteDispo());
        modificationLivre.setTitre(livreEditionDto.getTitre());

        return livreRepository.save(modificationLivre);
    }

    @Override
    public void supprimerLivre(int idLivre) {
        livreRepository.deleteById(idLivre);
    }
}
