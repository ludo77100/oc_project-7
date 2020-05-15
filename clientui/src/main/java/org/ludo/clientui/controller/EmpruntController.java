package org.ludo.clientui.controller;

import org.ludo.clientui.beans.EmpruntBean;
import org.ludo.clientui.beans.UtilisateurBean;
import org.ludo.clientui.proxies.MicroserviceBibliothequeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;

@Controller
public class EmpruntController {

    @Autowired
    MicroserviceBibliothequeProxy empruntProxy ;

    /**
     * Permet de récupérer la liste des emprunts d'un utilisateur
     * @param model instance du model en cours
     * @return la vue avec les emprunts de l'utilisateur
     */
    @GetMapping(value = "/emprunt/utilisateur")
    public String listeEmpruntUtilisateur(Model model){

        UtilisateurBean utilDet = (UtilisateurBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String pseudoEmprunteur = utilDet.getUsername();

        List<EmpruntBean> listeEmpruntsUtilisateur = empruntProxy.listeEmpruntUtilisateur(pseudoEmprunteur);
        model.addAttribute("listeEmpruntsUtilisateur", listeEmpruntsUtilisateur);

        return "/listeEmprunts" ;
    }

    /**
     * Permet de prolonger un emprunt
     * @param idEmprunt id de l'emprunt à prolonger
     * @return redirige vers la vue emprunt de l'utilisateur
     */
    @GetMapping(value = "/emprunt/prolonger/{idEmprunt}")
    public String prolongerEmprunt(@PathVariable("idEmprunt")Long idEmprunt){
        empruntProxy.prolongerEmprunt(idEmprunt);
        return "redirect:/emprunt/utilisateur";
    }
}