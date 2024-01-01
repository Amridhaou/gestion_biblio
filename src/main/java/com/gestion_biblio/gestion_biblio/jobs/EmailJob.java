
package com.gestion_biblio.gestion_biblio.jobs;
import com.gestion_biblio.gestion_biblio.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailJob {

    @Autowired
    private EmailService emailService;


    @Scheduled(cron = "0 * * * * *")
    protected void executeJob()  {
        try {


            // Maintenant, vous pouvez utiliser emailService pour envoyer des e-mails

            emailService.sendSimpleMessage("dhaouelamri@gmail.com", "Hey, n'oublie pas !", "Ceci est un rappel amical.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
