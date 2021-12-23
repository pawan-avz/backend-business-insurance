package com.backend.BIPC.services.quote;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.Premium;
import com.backend.BIPC.entities.quote.Property;
import com.backend.BIPC.repositories.PremiumRepository;
import com.backend.BIPC.repositories.PropertyRepository;
import com.backend.BIPC.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PremiumRepository premiumRepository;

    public Property findByUserId(Long id){
        return propertyRepository.findByUserId(id);
    }

    public void savePremium(Premium premium) {
        premiumRepository.save(premium);
    }
}
