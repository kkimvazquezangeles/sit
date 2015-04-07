package mx.edu.utec.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by betuzo on 25/01/15.
 */
public final class CsrfResponseHeaderFilter extends OncePerRequestFilter{

    protected static final String REQUEST_ATTRIBUTE_NAME = "_csrf";
    protected static final String RESPONSE_HEADER_NAME = "X-CSRF-HEADER";
    protected static final String RESPONSE_PARAM_NAME = "X-CSRF-PARAM";
    protected static final String RESPONSE_TOKEN_NAME = "X-CSRF-TOKEN";

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        CsrfToken token = (CsrfToken) request.getAttribute(REQUEST_ATTRIBUTE_NAME);

        logger.info(token.toString());

        // Spring Security will allow the Token to be included in this header name
        response.setHeader(RESPONSE_HEADER_NAME, token.getHeaderName());

        logger.info(token.getHeaderName());

        // Spring Security will allow the token to be included in this parameter name
        response.setHeader(RESPONSE_PARAM_NAME, token.getParameterName());

        logger.info(token.getParameterName());

        // this is the value of the token to be included as either a header or an HTTP parameter
        response.setHeader(RESPONSE_TOKEN_NAME, token.getToken());

        logger.info(token.getToken());

        filterChain.doFilter(request, response);
    }
}
