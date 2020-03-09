package org.ludo.bibliotheque.service.service.impl;

import org.ludo.bibliotheque.dao.EmpruntRepository;
import org.ludo.bibliotheque.entities.Emprunt;
import org.ludo.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
