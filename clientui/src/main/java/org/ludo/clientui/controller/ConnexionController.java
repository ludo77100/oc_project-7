package org.ludo.clientui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnexionController {

    @GetMapping(value = "/connexion")
    public String login(){
        return "connexion";
    }

}
