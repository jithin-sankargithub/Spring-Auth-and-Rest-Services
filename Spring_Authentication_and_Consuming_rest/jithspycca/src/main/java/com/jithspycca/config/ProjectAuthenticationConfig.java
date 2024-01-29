package com.jithspycca.config;

import com.jithspycca.model.Person;
import com.jithspycca.model.Roles;
import com.jithspycca.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.ClassName;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Component
public class ProjectAuthenticationConfig implements AuthenticationProvider {

    private static final Logger LOGGER = Logger.getLogger(ProjectAuthenticationConfig.class.getName());

    private PersonRepository personRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ProjectAuthenticationConfig(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LOGGER.info("Start of Authentication");
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Person person = personRepository.findByEmail(email);
        if(null != person && 0!= person.getPersonId()
        && passwordEncoder.matches(pwd,person.getPassword())){
            LOGGER.info("Authentication successful");
            return new UsernamePasswordAuthenticationToken(person.getEmail(),
                    null,getGrantedAuthorities(person.getRoles()));
        }else
            throw new BadCredentialsException("Invalid credentials");
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(Roles roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
