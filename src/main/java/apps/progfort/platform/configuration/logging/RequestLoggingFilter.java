package apps.progfort.platform.configuration.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) {
        try {
            LOGGER.info("Request Status: {} URI: {}, Method: {}, IP: {}"
                    , response.getStatus(),
                    request.getRequestURI(),
                    request.getMethod(),
                    request.getRemoteAddr()
            );
            filterChain.doFilter(request, response);
        } catch (ServletException | IOException e) {
            LOGGER.error("Error while logging request", e);
        }
    }
}
