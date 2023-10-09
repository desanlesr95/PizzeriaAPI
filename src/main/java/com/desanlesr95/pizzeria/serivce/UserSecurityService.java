package com.desanlesr95.pizzeria.serivce;

import com.desanlesr95.pizzeria.persitence.entity.UserEntity;
import com.desanlesr95.pizzeria.persitence.entity.UserRoleEntity;
import com.desanlesr95.pizzeria.persitence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findById(username).orElseThrow( () -> new UsernameNotFoundException("User " + username + " not found."));
        String[] roles = userEntity.getRoles().stream().map(UserRoleEntity::getRole).toArray(String[]::new);
        return User.builder().
                username(userEntity.getUsername()).
                password(userEntity.getPassword()).
                roles(roles).
                accountExpired(userEntity.getLocked()).
                disabled(userEntity.getDisabled()).
                build();
    }
}
