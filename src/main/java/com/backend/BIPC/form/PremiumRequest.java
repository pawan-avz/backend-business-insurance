package com.backend.BIPC.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PremiumRequest {
   private Long id;
   private Double premium;

   private Long propertyId;
}
