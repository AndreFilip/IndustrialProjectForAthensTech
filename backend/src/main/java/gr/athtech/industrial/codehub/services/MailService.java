package gr.athtech.industrial.codehub.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author George Lalas
 */
@Service("mailService")
public class MailService {
    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender sender;

    public void sendEmail(String recipient, String subject, String text) {
        log.info("Sending mail to {}, with subject '{}' and body '{}'", recipient, subject, text);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(text);
        sender.send(message);
    }
}
