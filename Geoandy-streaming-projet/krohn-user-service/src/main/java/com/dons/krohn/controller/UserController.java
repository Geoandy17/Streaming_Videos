package com.dons.krohn.controller;

import com.dons.krohn.dto.UserDTO;
import com.dons.krohn.request.UserCreateRequestModel;
import com.dons.krohn.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserCreateRequestModel userRequest) {
        if(userService.findByEmail(userRequest.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDTO userDTO = modelMapper.map(userRequest, UserDTO.class);
        userDTO = userService.insert(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    /**
     * Get user by id
     *
     * @param id
     * @return {@link ResponseEntity}
     */
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserDTO> getById(@PathVariable("id") String id) {
        UserDTO userDto = userService.findById(id);
        return (userDto != null) ? ResponseEntity.status(HttpStatus.OK).body(userDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
