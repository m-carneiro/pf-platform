//package apps.progfort.platform.configuration.security;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//
//import java.io.IOException;
//
//public class CsrfTokenAwareLogoutSuccessHandler implements LogoutSuccessHandler {
//
//    private final CsrfTokenRepository tokenRepository;
//    private final LogoutSuccessHandler delegate = new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK);
//
//    public CsrfTokenAwareLogoutSuccessHandler(CsrfTokenRepository tokenRepository) {
//        this.tokenRepository = tokenRepository;
//    }
//
//    @Override
//    public void onLogoutSuccess(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication
//    ) throws IOException, ServletException {
//
//        CsrfToken token = tokenRepository.generateToken(request);
//
//        this.tokenRepository.saveToken(token, request, response);
//        this.delegate.onLogoutSuccess(request, response, authentication);
//    }
//}
