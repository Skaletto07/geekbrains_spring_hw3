package com.kostkin.hw_3.security;

import com.kostkin.hw_3.models.Role;
import com.kostkin.hw_3.repositories.RoleRepository;
import com.kostkin.hw_3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DatabaseUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.kostkin.hw_3.models.User> user = userRepository.findByUsername(username);
        com.kostkin.hw_3.models.User user1;
        if (user.isPresent()) {
            user1 = user.get();
        } else {
            throw new UsernameNotFoundException("This user not found");
        }
        Optional<Role> byId = roleRepository.findById(user1.getId());
        Role role = byId.get();

        return User.builder()
                .username(username)
                .password(user1.getPassword())
                .authorities(role.getAuthority())
                .build();
    }
}
