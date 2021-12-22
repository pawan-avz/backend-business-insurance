package com.backend.BIPC.entities.quote;

import com.backend.BIPC.entities.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PropertyDetails {
    @Id
    private Long propertyId;
    private String item;
    private String model;
    private Long purchaseRate;
    private String purchaseDate;
    private String coverageDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "property_details_id")
    private User property_details;

    public User getProperty_details() {
        return property_details;
    }

    public void setProperty_details(User property_details) {
        this.property_details = property_details;
    }
}
