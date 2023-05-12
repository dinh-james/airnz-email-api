package nz.dinh.airnzemailapi.security.providers;

import nz.dinh.airnzemailapi.model.AppUser;
import nz.dinh.airnzemailapi.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomIdentityAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    public CustomIdentityAuthenticationProvider(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    UserDetails isValidUser(String username, String password) {

        Optional<AppUser> appUser = userRepository.findByUsername(username);

        if(appUser.isEmpty())
        {
            return null;
        }

        if(appUser.get().getPassword().equals(password))
        {
            return User
                    .withUsername(username)
                    .password("NOT_DISCLOSED")
                    .roles("USER_ROLE")
                    .build();
        }

        return null;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = isValidUser(username, password);

        if (userDetails != null) {
            return new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("Invalid Credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }
}
