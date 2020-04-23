package org.ludo.bibliotheque.batch;

import org.ludo.bibliotheque.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJob {

    @Autowired
    EmailService emailService ;

    @Scheduled(cron = "0 14 * * * *")
    public void lendingRevival() throws Exception {

        emailService.envoyerEmailRelance();

    }



}
