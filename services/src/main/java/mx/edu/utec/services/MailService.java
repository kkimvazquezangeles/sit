package mx.edu.utec.services;

import org.springframework.mail.SimpleMailMessage;

import java.util.Map;

/**
 * Created by betuzo on 26/04/15.
 */
public interface MailService {
    public void send(SimpleMailMessage msg, Map<String, Object> hTemplateVariables);
}
