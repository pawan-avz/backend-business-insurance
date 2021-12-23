package com.backend.BIPC.controllers.quote;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.Premium;
import com.backend.BIPC.entities.quote.Property;
import com.backend.BIPC.form.PremiumResponse;
import com.backend.BIPC.form.PremiumRequest;
import com.backend.BIPC.form.Test;
import com.backend.BIPC.repositories.PropertyRepository;
import com.backend.BIPC.repositories.UserRepository;
import com.backend.BIPC.services.quote.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class PremiumController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Property property;

    @Autowired
    private PremiumService premiumService;

    @Autowired
    private PropertyRepository propertyRepository;


    @PostMapping("/quote/premium-calculation")
    public ResponseEntity<PremiumResponse> premiumCalculation(@RequestBody Test test) {

        System.out.println(test);
        PremiumResponse premiumResponse=null;
        try {
            User user = userRepository.findByUsername(test.getEmail());
            Long userId = user.getId();

            Property property = propertyRepository.findByUserId(userId);

            premiumResponse = new PremiumResponse(
                    property.getPropertyId(),property.getItem(),
                    property.getPurchaseRate() * 0.1,
                    property.getInsuranceType(),
                    property.getInsuranceSubType());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(premiumResponse);
    }


    //
    @PostMapping("/quote/save-premium")
    public String savePremium(@Valid @RequestBody PremiumRequest premiumRequest){

        System.out.println(premiumRequest);

        Property property = propertyRepository.findByPropertyId(premiumRequest.getPropertyId());

        System.out.println(property);
        Premium premium = new Premium(
                null,
                premiumRequest.getPremium(),
                property
        );
        premiumService.savePremium(premium);
        return "Premium Details Successfully saved!";
    }
}
