package com.nsa.group6.repositories;

import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//@Repository
/**
 * Worked on by Clive
 */
public interface UserRepository extends JpaRepository<User,String>{

    User findByUsername(String aUsername);






}
