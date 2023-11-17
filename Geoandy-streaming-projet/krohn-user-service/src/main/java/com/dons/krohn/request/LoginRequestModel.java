package com.dons.krohn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class LoginRequestModel {
    private String email;
    private String username;
    private String password;
}
