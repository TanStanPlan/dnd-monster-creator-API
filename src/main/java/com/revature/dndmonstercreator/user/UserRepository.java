package com.revature.dndmonstercreator.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "FROM User WHERE email= :email")
    Optional<User> findByEmail(String email);

    @Query(value = "FROM User WHERE username= :username")
    Optional<User> findByUsername(String username);

    @Query(value = "FROM User WHERE email = :email AND password = :password")
    Optional<User> loginCredentialCheck(String email, String password);


}
