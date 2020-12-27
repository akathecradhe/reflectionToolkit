package com.nsa.group6.service;

import com.nsa.group6.domain.User;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Worked on by Clive
 */
@Service
public interface UserService  {
    public void saveUser(User aUser);

    public void updateUser(User aUser);

    public void deleteUser(Long id);

    List<User> getAllUsers();

    public Optional<User> findUserByUsername(String aName);

    // TODO: 24/11/2020  order by tag/ orderby event type, Ukspsf element group,
//    public List<User> findUsersByMostRecent();
//

//
//    public Optional<User> findUsersById(Long id);
//
}
