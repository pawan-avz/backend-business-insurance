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
public class Property {
    @Id
    @GeneratedValue
    private Long id;
    private String item;
    private String model;
    private Long purchaseRate;
    private String purchaseDate;
    private String coverageDate;
    private String insuranceType;
    private String insuranceSubType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
