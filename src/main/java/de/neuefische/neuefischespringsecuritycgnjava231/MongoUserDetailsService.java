package de.neuefische.neuefischespringsecuritycgnjava231;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoUserDetailsService implements UserDetailsService {
    private final MongoUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MongoUser mongoUser = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(
                mongoUser.username(),
                mongoUser.password(),
                List.of(new SimpleGrantedAuthority("ROLE_" + mongoUser.role()))
        );
    }
}
