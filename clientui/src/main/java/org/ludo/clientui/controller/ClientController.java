package org.ludo.clientui.controller;

import org.ludo.clientui.beans.LivreBean;
import org.ludo.clientui.proxies.MicroserviceLivresProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceLivresProxy livresProxy ;

    @RequestMapping(value = "/")
    public String index(Model model){

        List<LivreBean> listeLivres = livresProxy.listeLivre();

        model.addAttribute("listeLivres", listeLivres);

        return "index";
    }

}
