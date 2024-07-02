package africa.semicolon.security.filter;

import africa.semicolon.dtos.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final ObjectMapper objectMapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            LoginRequest loginRequest = retrieveCredentials(request);
            String username = loginRequest.getEmail();
            String password = loginRequest.getPassword();
            //3. Create an Authentication object that is not yet authenticated
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            //4a. Pass the unauthenticated Authentication
            // object to the AuthenticationManager
            //4b. Get back the Authentication result from the AuthenticationManager
            Authentication authenticationResult =
                    authenticationManager.authenticate(authentication);
            //Put the authentication result in the security context
            SecurityContextHolder.getContext().setAuthentication(authenticationResult);
            return authenticationResult;

        } catch (IOException e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }

    private LoginRequest retrieveCredentials(HttpServletRequest request) throws IOException {
        InputStream requestBodyStream = request.getInputStream();
        LoginRequest loginRequest =
                objectMapper.readValue(requestBodyStream, LoginRequest.class);
        return loginRequest;
    }

}
