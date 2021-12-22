package com.backend.BIPC.controllers.quote;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.PropertyDetails;
import com.backend.BIPC.form.PremiumResponse;
import com.backend.BIPC.services.quote.PremiumCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/quote")
public class PremiumCalculationController {

    @Autowired
    private PropertyDetails propertyDetails;

    @Autowired
    private PremiumCalculationService premiumCalculationService;

    @GetMapping("/premium-calculation")
    public ResponseEntity<PremiumResponse> premiumCalculation( @RequestHeader("email") String email){

        User user = premiumCalculationService.findByUsername(email);
        Long userId = user.getId();

        PropertyDetails propertyDetails = premiumCalculationService.getAllDetails(userId);

        //getting rate from property details
        Long purchaseRate = propertyDetails.getPurchaseRate();
        String item = propertyDetails.getItem();

        Double basePremium = purchaseRate*0.1;


        PremiumResponse premiumResponse = new PremiumResponse(basePremium,item);

        System.out.println(propertyDetails);

        return ResponseEntity.ok(premiumResponse);
    }
}
