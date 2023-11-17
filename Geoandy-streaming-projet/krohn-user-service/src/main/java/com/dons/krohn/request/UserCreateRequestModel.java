package com.dons.krohn.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class UserCreateRequestModel {

    @NotNull(message = "First name cannot  be null")
    private String firstName;
    @NotNull(message = "Last Name cannot be null")
    private String lastName;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email")
    private String email;
    @NotNull(message = "Password cannot be null")
    @Size(min = 8,max=64,message = "Password must be equal than 8 characters and less or equal 64 characters")
    private String password;
    @NotNull(message = "Username cannot be null")
    private String username;
    @NotNull(message = "Photo cannot be empty")
    private String avatarUrl;
    @NotNull(message = "Address cannot be null")
    private String address;
}
