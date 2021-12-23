package com.backend.BIPC.services.quote;

import com.backend.BIPC.entities.quote.Property;
import com.backend.BIPC.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property savePropertyDetails(Property propertyDetails){
        return propertyRepository.save(propertyDetails);
    }
}
