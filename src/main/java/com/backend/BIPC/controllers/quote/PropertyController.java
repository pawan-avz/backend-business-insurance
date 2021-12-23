package com.backend.BIPC.controllers.quote;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.Property;
import com.backend.BIPC.form.PropertyRequest;
import com.backend.BIPC.services.auth.UserService;
import com.backend.BIPC.services.quote.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class PropertyController {


    @Autowired
    private PropertyService propertyDetailsService;

    @Autowired
    private UserService userService;


    @PostMapping("/quote/property-details")
    public Property savePropertyDetails(@Valid @RequestBody PropertyRequest propertyRequest){

        User user = userService.getUserByUsername(propertyRequest.getEmail());
        Property propertyDetails = new Property(
                null,propertyRequest.getItem(),propertyRequest.getModel(),
                propertyRequest.getPurchaseRate(),
                propertyRequest.getPurchaseDate(),
                propertyRequest.getCoverageDate(),
                propertyRequest.getInsuranceType(),
                propertyRequest.getInsuranceSubType(),
                user
        );
        System.out.println(propertyDetails);
        return propertyDetailsService.savePropertyDetails(propertyDetails);
    }

}
