package org.ludo.bibliotheque.batch;

import org.ludo.bibliotheque.dao.EmailRepository;
import org.ludo.bibliotheque.dao.EmpruntRepository;
import org.ludo.bibliotheque.proxies.MicroserviceUtilisateurProxy;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MyTaskOne implements Tasklet {

    private final EmpruntRepository empruntRepository ;
    private final EmailRepository emailRepository ;
    private final MicroserviceUtilisateurProxy microserviceUtilisateurProxy ;
    private final JavaMailSenderImpl sender ;

    public MyTaskOne(EmpruntRepository empruntRepository, EmailRepository emailRepository, MicroserviceUtilisateurProxy microserviceUtilisateurProxy, JavaMailSenderImpl sender) {
        this.empruntRepository = empruntRepository ;
        this.emailRepository = emailRepository ;
        this.microserviceUtilisateurProxy = microserviceUtilisateurProxy ;
        this.sender = sender ;
    }


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        return null;
    }
}
