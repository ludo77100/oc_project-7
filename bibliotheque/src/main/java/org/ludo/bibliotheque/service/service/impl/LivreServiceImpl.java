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

    /**
     * Trouve tous les livres
     * @return liste des livres
     */
    @Override
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    /**
     * Trouve les livres contenant dans leur titre un mot clé
     * @param mc mot clé
     * @return la liste des livres
     */
    @Override
    public List<Livre> findByTitreContainingIgnoreCase(String mc) {
        return livreRepository.findByTitreContainingIgnoreCase(mc);
    }

    /**
     * Trouve un livre par son id
     * @param idLidvre id du livre à trouver
     * @return le livre
     */
    @Override
    public Livre findLivreById(Long idLidvre) {
        return livreRepository.findById(idLidvre).get();
    }

    /**
     * Enregistre un nouveau livre
     * @param livre paramètre du livre à enregistrer
     * @return un nouveau livre
     */
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

    /**
     * Supprime un livre par son id
     * @param idLivre id du livre à supprimer
     */
    @Override
    public void supprimerLivre(Long idLivre) {
        livreRepository.deleteById(idLivre);
    }


}
