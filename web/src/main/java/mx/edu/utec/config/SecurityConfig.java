package mx.edu.utec.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by kkimvazquezangeles on 05/04/15.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Setup in memory authentication.
     *
     * @param auth
     * @throws Exception
     */
    @Inject
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }

    /**
     * Configure HttpSecurity, namely setting the CsrfTokenRepository to our own implementation
     * of HttpHeaderCsrfTokenRepository.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new CsrfResponseHeaderFilter(), CsrfFilter.class)
                .authorizeRequests()
                .antMatchers("/scripts/**", "/styles/**", "/font/**", "/fonts/**").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll();
    }
}
