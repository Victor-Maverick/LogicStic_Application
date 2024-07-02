package africa.semicolon.security.service;

import africa.semicolon.data.model.Customer;
import africa.semicolon.security.models.SecureUser;
import africa.semicolon.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final CustomerService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Customer user = userService.findByUsername(username);
            return new SecureUser(user);
        }catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
