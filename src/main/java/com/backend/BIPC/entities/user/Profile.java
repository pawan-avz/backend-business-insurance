package com.backend.BIPC.entities.user;

import com.backend.BIPC.entities.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.nio.file.Path;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private int pincode;
    @Column(nullable = false)
    private String image;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;




}
