package com.backend.BIPC.services.auth;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.auth.CustomUserDetails;
import com.backend.BIPC.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
//    private LoginUserRepository loginUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(email);
        System.out.println("custom user services "+user);
        if(user ==null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new CustomUserDetails(user);
//        return null;
    }
}
