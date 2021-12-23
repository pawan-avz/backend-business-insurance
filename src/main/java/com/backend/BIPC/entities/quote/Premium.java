package com.backend.BIPC.entities.quote;

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
public class Premium {
    @Id
    @GeneratedValue
    private Long id;
    private Double premium;
    @ManyToOne
    @JoinColumn(name = "property_id",referencedColumnName = "id")
    private Property property;
}
