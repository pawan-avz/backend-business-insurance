package com.backend.BIPC.services.quote;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.PropertyDetails;
import com.backend.BIPC.repositories.PropertyDetailsRepository;
import com.backend.BIPC.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PremiumCalculationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyDetailsRepository propertyDetailsRepository;


    public User findByUsername(String email){
        return userRepository.findByUsername(email);
    }

    public PropertyDetails getAllDetails(Long id){
        return propertyDetailsRepository.getById(id);
    }
}
