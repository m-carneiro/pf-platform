package apps.progfort.platform.configuration.security;

import apps.progfort.platform.configuration.filter.CsrfCookieFilter;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http)
      throws Exception {
    CsrfTokenRequestAttributeHandler csrfToken =
        new CsrfTokenRequestAttributeHandler();
    csrfToken.setCsrfRequestAttributeName("_csrf");
    http.securityContext()
        .requireExplicitSave(false)
        .and()
        .sessionManagement(
            session
            -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
        .cors()
        .configurationSource(request -> {
          CorsConfiguration cors = new CorsConfiguration();
          cors.setAllowedOrigins(Collections.singletonList("*"));
          cors.setAllowedMethods(
              Collections.singletonList("http://localhost:3000"));
          cors.setAllowCredentials(true);
          cors.setAllowedHeaders(Collections.singletonList("*"));
          cors.setMaxAge(3600L);
          return cors;
        })
        .and()
        .csrf((csrf)
                  -> csrf.csrfTokenRequestHandler(csrfToken)
                         .ignoringRequestMatchers("/api/**")
                         .csrfTokenRepository(
                             CookieCsrfTokenRepository.withHttpOnlyFalse()))
        .addFilterAt(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
        .authorizeHttpRequests()
        .requestMatchers("/api/**")
        .permitAll()
        .and()
        .formLogin()
        .and()
        .httpBasic();

    return http.build();
  }
}
