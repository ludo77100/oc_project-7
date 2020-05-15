package org.ludo.clientui.controller;

import org.ludo.clientui.beans.LivreBean;
import org.ludo.clientui.proxies.MicroserviceBibliothequeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LivreController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MicroserviceBibliothequeProxy livresProxy ;

    /**
     * Controlleur pour l'index de l'application
     * @return redirige vers la liste des livres
     */
    @GetMapping(value = "")
    public String index(){
        return "redirect:/liste";
    }

    /**
     * Permet d'afficher la liste des livres
     * @param model instance du model en cours
     * @return la vue index avec la liste des livres
     */
    @RequestMapping(value = "/liste")
    public String liste(Model model){
        List<LivreBean> listeLivres = livresProxy.listeLivre();
        model.addAttribute("listeLivresBean", listeLivres);
        log.info("Récupération liste des livres");
        return "index";
    }

    /**
     * Permet d'effectuer une recherche sur les titres des livres
     * @param model instance du model en cours
     * @param mc mot clé pour la recherche
     * @return la vue avec la liste de livre recherchés
     */
    @GetMapping(value = "/listeRecherche")
    public String listeLivreRecherche(Model model, @RequestParam(name="mc")String mc){
        System.out.println(mc);
        List<LivreBean> listeLivres = livresProxy.listeLivreRecherche(mc);
        System.out.println("2eme " + mc);
        model.addAttribute("listeLivresBean", listeLivres);
        model.addAttribute(mc);
        System.out.println(listeLivres);
        return "index";
    }

    /**
     * Permet d'afficher les détails d'un livre
     * @param idLidvre id du livre à afficher
     * @param model instance du model en cours
     * @return la vue avec les détails du livre demandé
     */
    @GetMapping(value = "/livre/{idLivre}")
    public String findLivreById(@PathVariable("idLivre")Long idLidvre, Model model){
        LivreBean livreDisplay = livresProxy.findLivreById(idLidvre);
        model.addAttribute("livreDetails", livreDisplay);
        return "livre";
    }

}
