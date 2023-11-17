package com.dons.krohn.service;

import com.dons.krohn.dao.UserRepository;
import com.dons.krohn.dto.UserDTO;
import com.dons.krohn.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO insert(UserDTO user) {
        user.setId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user1 = modelMapper.map(user,User.class);
        user1.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user1);

        UserDTO returnValue = modelMapper.map(user1,UserDTO.class);

        return returnValue;
    }

    @Override
    public UserDTO findById(String id) {
        User userEntity = userRepository.findUserById(id);

        if(userEntity == null)
            throw new UsernameNotFoundException(id);

        UserDTO userDto = new ModelMapper().map(userEntity, UserDTO.class);

        return userDto;
    }

    @Override
    public UserDTO findByEmail(String email) {
        User userEntity = userRepository.findByEmail(email);

        if(userEntity == null)
            return null;

        return new ModelMapper().map(userEntity, UserDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByEmail(username);
        if(userEntity == null)
            throw new UsernameNotFoundException(username);
        return (UserDetails) new User(username, userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<GrantedAuthority>());
    }
}
