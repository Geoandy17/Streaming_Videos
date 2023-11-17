package com.dons.krohn.controller;

import com.dons.krohn.ApiInformation;
import com.dons.krohn.dto.PatchUserDTO;
import com.dons.krohn.dto.UserDTO;
import com.dons.krohn.entity.User;
import com.dons.krohn.mapper.UserMapper;
import com.dons.krohn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/users")
    public List<UserDTO> getUser(){
        return userMapper.toUserDTO(userService.findAll());
    }

    @GetMapping("/users/{user_id}")
    public UserDTO getUserById(@PathVariable("user_id") Long id){
        return userMapper.toUserDTO(userService.findUserById(id));
    }

    @PostMapping("/users")
    public UserDTO postUser(@RequestBody UserDTO user){
        return userMapper.toUserDTO(userService.saveUser(userMapper.toUserEntity(user)));
    }

    @DeleteMapping("/users/{id}")
    public ApiInformation deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ApiInformation("Deleted user", HttpStatus.OK.value());
    }

    @PatchMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, @Valid @RequestBody PatchUserDTO userDTO) {
        return userService.updateUserById(id, userDTO);
    }


}
