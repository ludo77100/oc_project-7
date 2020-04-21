package org.ludo.bibliotheque.service.service.impl;

import org.ludo.bibliotheque.beans.UtilisateurBean;
import org.ludo.bibliotheque.entities.Emprunt;
import org.ludo.bibliotheque.proxies.MicroserviceUtilisateurProxy;
import org.ludo.bibliotheque.service.EmailService;
import org.ludo.bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSenderImpl sender;
    
    @Autowired
    private EmpruntService empruntService ;

    @Autowired
    MicroserviceUtilisateurProxy microserviceUtilisateurProxy ;

    @Override
    public void envoyerEmailRelance(){

        SimpleMailMessage message = new SimpleMailMessage();
        List<Emprunt> listeEmpruntNonRendue = empruntService.listeLivreNonRendueApresDateFin();

        for (Emprunt e: listeEmpruntNonRendue) {
            UtilisateurBean utilisateur = microserviceUtilisateurProxy.login(e.getPseudoEmprunteur());

            message.setTo(utilisateur.getEmail());
            message.setSubject("Livre " + e.getLivre().getTitre() + " non rendue");

            message.setText("Bonjour " + e.getPseudoEmprunteur() + "! Le livre " + e.getLivre().getTitre() +
                    "était à rendre avant le " + e.getDateFin() + " ! Merci de nous le ramener au plus tôt. Cordialement");

            sender.send(message);
        }



    }
}
