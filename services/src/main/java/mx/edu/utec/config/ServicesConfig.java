package mx.edu.utec.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "mx.edu.utec.services" })
public class ServicesConfig {

}
