package mx.edu.utec.services.impl;

import mx.edu.utec.services.MailService;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * Created by betuzo on 26/04/15.
 */
@Service
public class VelocityMailServiceImpl implements MailService {

    private static final Logger logger = LoggerFactory.getLogger(VelocityMailServiceImpl.class);

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send(final SimpleMailMessage msg, final Map<String, Object> hTemplateVariables) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(msg.getTo());
                message.setCc(msg.getCc());
                message.setFrom(msg.getFrom());
                message.setSubject(msg.getSubject());

                String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/emailBody.vm", hTemplateVariables);

                logger.info("body={}", body);

                message.setText(body, true);
            }
        };

        mailSender.send(preparator);

        logger.info("Sent e-mail to '{}'.", msg.getTo());
    }
}
