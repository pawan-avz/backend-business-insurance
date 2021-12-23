package com.backend.BIPC.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PropertyRequest {
    private Long propertyId;
    private String item;
    private String model;
    private Long purchaseRate;
    private String purchaseDate;
    private String coverageDate;
    private String insuranceType;
    private String insuranceSubType;

    private String email;
}
