package org.ludo.clientui.controller;

import org.ludo.clientui.beans.UtilisateurBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UtilisateurController {

    /**
     * Permet d'afficher les détails d'un utilisateur
     * @param model instance du model en cours
     * @param request HttpServletRequest, ici pour vérifier qu'un utilisateur est connecté
     * @return la vue avec les informations personelles de l'utilisateur
     */
    @GetMapping(value = "/infosPerso")
    public String infosPerso(Model model, HttpServletRequest request) {
        if (request.getRemoteUser() == null) {
            return "connexion";
        } else {
            UserDetails utilDet = (UtilisateurBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("infosUtilisateur", utilDet);
            return "/infosPerso";
        }
    }
}
