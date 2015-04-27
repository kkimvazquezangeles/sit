package mx.edu.utec.services;

import mx.edu.utec.config.MailConfig;
import mx.edu.utec.config.PersistenceConfig;
import mx.edu.utec.config.ServicesConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
/**
 * Created by betuzo on 26/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServicesConfig.class, PersistenceConfig.class, MailConfig.class})
public class MailServiceTest {

    @Autowired
    MailService mailService;

    @Autowired
    SimpleMailMessage templateMessage;

    @Test
    public void testSend(){
        assertNotNull("MailService is null.", mailService);
        assertNotNull("SimpleMailMessage is null.", templateMessage);

        templateMessage.setTo("kkimvazquezangeles@hotmail.com");

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("tutorName", "Jose Soto");
        props.put("alumnoName", "Karen Vazquez");

        mailService.send(templateMessage, props);
    }
}
