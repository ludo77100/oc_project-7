package org.ludo.clientui.controller;

import org.ludo.clientui.beans.EmpruntBean;
import org.ludo.clientui.beans.UtilisateurBean;
import org.ludo.clientui.proxies.MicroserviceBibliothequeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmpruntController {

    @Autowired
    MicroserviceBibliothequeProxy empruntProxy ;

    @GetMapping(value = "/emprunt/utilisateur")
    public String listeEmpruntUtilisateur(Model model){
        UserDetails utilDet = (UtilisateurBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String pseudo = utilDet.getUsername();
        List<EmpruntBean> listeEmpruntsUtilisateur = empruntProxy.listeEmpruntUtilisateur(pseudo);
        model.addAttribute("listeEmpruntsUtilisateur", listeEmpruntsUtilisateur);
        return "/listeEmprunts" ;
    }

}
