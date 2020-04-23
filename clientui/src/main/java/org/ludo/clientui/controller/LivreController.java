package org.ludo.clientui.controller;

import org.ludo.clientui.beans.LivreBean;
import org.ludo.clientui.proxies.MicroserviceBibliothequeProxy;
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

    @Autowired
    private MicroserviceBibliothequeProxy livresProxy ;

    @RequestMapping(value = "/")
    public String index(Model model){
        List<LivreBean> listeLivres = livresProxy.listeLivre();
        model.addAttribute("listeLivresBean", listeLivres);
        System.out.println(listeLivres);
        return "/index";
    }

    @GetMapping(value = "/listeRecherche")
    public String listeLivreRecherche(Model model, @RequestParam(name="mc")String mc){
        System.out.println(mc);
        List<LivreBean> listeLivres = livresProxy.listeLivreRecherche(mc);
        System.out.println("2eme " + mc);
        model.addAttribute("listeLivresBean", listeLivres);
        model.addAttribute(mc);
        System.out.println(listeLivres);
        return "/index";
    }

    @GetMapping(value = "/livre/{idLivre}")
    public String findLivreById(@PathVariable("idLivre")Long idLidvre, Model model){
        LivreBean livreDisplay = livresProxy.findLivreById(idLidvre);
        model.addAttribute("livreDetails", livreDisplay);
        return "/livre";
    }

}
