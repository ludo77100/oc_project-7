package org.ludo.bibliotheque.batch;

import org.ludo.bibliotheque.entities.Email;
import org.ludo.bibliotheque.service.EmailService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJob {

    @Autowired
    EmailService emailService ;

    @Scheduled(cron = "0 */1 * * * *")
    public void lendingRevival() throws Exception {
        System.out.println("TEST");
        emailService.envoyerEmailRelance();
    }



}
