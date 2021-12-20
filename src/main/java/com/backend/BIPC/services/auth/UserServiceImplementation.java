package com.backend.BIPC.services.auth;

import com.backend.BIPC.Exception.GenericException;
import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.form.ChangePasswordForm;
import com.backend.BIPC.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String changePassword(ChangePasswordForm changePasswordForm) throws Exception {
        User user = userRepository.findByUsername(changePasswordForm.getUsername());
        if (user == null) {
            throw new GenericException("User is not found !!");
        } else {
            if(bCryptPasswordEncoder.matches(changePasswordForm.getOldPassword(),user.getPassword())){
                user.setPassword(bCryptPasswordEncoder.encode(changePasswordForm.getNewPassword()));
                userRepository.save(user);
                return "Password is updated successfully";
            }
            else {
                throw new GenericException("Old password is not matched");
            }

        }

    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
