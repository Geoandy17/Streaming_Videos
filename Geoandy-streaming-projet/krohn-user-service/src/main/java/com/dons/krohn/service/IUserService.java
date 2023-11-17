package com.dons.krohn.service;

import com.dons.krohn.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    UserDTO insert(UserDTO user);
    UserDTO findById(String id);
    UserDTO findByEmail(String email);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
