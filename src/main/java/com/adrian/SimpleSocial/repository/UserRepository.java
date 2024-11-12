package com.adrian.SimpleSocial.repository;

import com.adrian.SimpleSocial.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username); // Custom method for finding user by username
}