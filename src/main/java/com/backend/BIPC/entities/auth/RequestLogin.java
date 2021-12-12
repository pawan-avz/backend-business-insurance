package com.backend.BIPC.entities.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestLogin {
    @Id
    private Long id;
    private String email;
    private String password;
    private String role;
}
