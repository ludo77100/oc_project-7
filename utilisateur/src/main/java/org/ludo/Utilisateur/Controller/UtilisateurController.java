package org.ludo.Utilisateur.Controller;

import io.swagger.annotations.ApiOperation;
import org.ludo.Utilisateur.dao.UtilisateurRepository;
import org.ludo.Utilisateur.dto.UtilisateurDto;
import org.ludo.Utilisateur.entities.Utilisateur;
import org.ludo.Utilisateur.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @ApiOperation("Pour retourner une liste des utilisateurs")
    @GetMapping(value = "/listeUtilisateur")
    public List<Utilisateur> listeUtilisateur(){
        return utilisateurService.findAll();
    }



    @ApiOperation(value = "Pour s'identifier")
    @GetMapping(value = "/utilisateur/{pseudo}")
    public Utilisateur login(@PathVariable String pseudo){
        Utilisateur utilisateur = utilisateurService.findByPseudo(pseudo);
        return utilisateur;
    }

    @ApiOperation(value = "Pour enregistrer un nouvel utilisateur")
    @PostMapping(value = "/utilisateur")
    public Utilisateur enregistrerUtilisateur(@RequestBody UtilisateurDto utilisateurDto){
        return utilisateurService.enregistrerUtilisateur(utilisateurDto);
    }

    @ApiOperation(value = "Pour modifier les privilède d'un utilisateur")
    @PutMapping(value = "/utilisateur/{pseudo}/{privilege}")
    public Utilisateur modificationPrivilege(@PathVariable String pseudo, @PathVariable String privilege){
        switch (privilege){
            case "utilisateur":
                return utilisateurService.privilegeUtilisateur(pseudo) ;
            case "bibliothécaire":
                return utilisateurService.privilegeBibliothecaire(pseudo) ;
            case "administrateur":
                return utilisateurService.privilegeAdministrateur(pseudo) ;
        }
        return null ;
    }
}
