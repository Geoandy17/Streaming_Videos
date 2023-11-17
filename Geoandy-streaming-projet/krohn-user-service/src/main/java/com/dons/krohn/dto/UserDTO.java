package com.dons.krohn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.io.Serializable;
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class UserDTO implements Serializable {
    private String id;
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private String avatarUrl;
    private String address;
}
