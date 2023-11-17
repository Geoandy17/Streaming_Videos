package com.dons.krohn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class User {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String avatarUrl;
    private String address;
    private String encryptedPassword;

    public User(String username, String encryptedPassword, boolean b, boolean b1, boolean b2, boolean b3, ArrayList<GrantedAuthority> grantedAuthorities) {
    }
}
