package com.dons.krohn.dao;

import com.dons.krohn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findUserById(String id);
}
