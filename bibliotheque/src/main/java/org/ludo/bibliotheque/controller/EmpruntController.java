package org.ludo.bibliotheque.controller;

import io.swagger.annotations.ApiOperation;
import org.ludo.bibliotheque.dto.EmpruntDto;
import org.ludo.bibliotheque.entities.Emprunt;
import org.ludo.bibliotheque.entities.Livre;
import org.ludo.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpruntController {

    @Autowired
    EmpruntService empruntService ;

    @ApiOperation(value = "Pour lister les emprunts")
    @GetMapping(value = "/listeEmprunt")
    public List<Emprunt> listeEmprunt(){
        return empruntService.findAll();
    }

    @ApiOperation(value = "Pour trouver un emprunt par son id")
    @GetMapping(value = "/emprunt/{idEmprunt}")
    public Optional<Emprunt> findById(@RequestParam Long idEmprunt){
        return empruntService.findById(idEmprunt);
    }

    @ApiOperation(value = "Pour ouvrir un emprunt")
    @PostMapping(value = "/emprunt/")
    public Emprunt ouvrirEmprunt(@RequestBody EmpruntDto empruntDto, Livre livre){
        return empruntService.ouvrirEmprunt(empruntDto, livre);
    }

    @ApiOperation(value = "Permet de de cloturer un emprunt")
    @PutMapping(value = "emprunt/{idEmprunt}")
    public Emprunt cloturerEmprunt(@RequestParam Long idEmprunt){
        return empruntService.cloturerEmprunt(idEmprunt);
    }

}
