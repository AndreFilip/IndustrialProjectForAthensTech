package gr.athtech.industrial.codehub.ServicesTest;

import gr.athtech.industrial.codehub.RepositoryTests.CodeHubUserRepoTest;
import gr.athtech.industrial.codehub.repositories.RoleRepository;
import gr.athtech.industrial.codehub.services.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTests {

    private static final Logger log = LoggerFactory.getLogger(CodeHubUserRepoTest.class);

    @Autowired
    private MailService mailService;

    @Test
    public void sendEmailsTest(){
        log.info("Testing mailer service...");
        List<String> mailingList = new ArrayList<>();
        mailingList.add("glalas@athtech.gr");
        mailingList.add("jnikolakopoulos@athtech.gr");
        mailingList.add("etsiris@athtech.gr");
        mailingList.add("pkourempanas@athtech.gr");
        mailingList.add("amelkonis@athtech.gr");
        mailingList.add("afilippatos@athtech.gr");
        for(String address : mailingList){
            log.info("Sending Test email to : {}", address);
            mailService.sendEmail(address,"CodeHub Platform email integration tests","This is an automated message from" +
                    "CodeHub platform! If you are reading this, the mail service works!");
        }

    }
}
