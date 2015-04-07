package mx.edu.utec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by betuzo on 28/11/14.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.codigoartesanal.hoteladn.controller" })
@Import({ PersistenceConfig.class, ServicesConfig.class, SecurityConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**"       , "/js/**"     , "/fonts/**")
                .addResourceLocations("/public/css/", "/public/js/", "/public/fonts/")
                .setCachePeriod(315569126);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/403").setViewName("403");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/public/");
        viewResolver.setSuffix(".html");
        viewResolver.setViewClass(InternalResourceView.class);
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }
}