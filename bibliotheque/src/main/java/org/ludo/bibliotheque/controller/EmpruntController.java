package org.ludo.bibliotheque.controller;

import io.swagger.annotations.ApiOperation;
import org.ludo.bibliotheque.entities.Emprunt;
import org.ludo.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
