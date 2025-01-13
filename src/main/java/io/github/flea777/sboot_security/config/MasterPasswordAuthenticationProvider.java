package io.github.flea777.sboot_security.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MasterPasswordAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        var login = authentication.getName();
        var password = (String) authentication.getCredentials();

        var masterLogin = "master";
        var masterPassword = "@321";

        if(masterLogin.equals(login) && masterPassword.equals(password)) {
            return new UsernamePasswordAuthenticationToken
            ("Master", null, List.of(new SimpleGrantedAuthority("ADMIN")));
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
