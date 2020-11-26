package com.nsa.group6.repositories;

import com.nsa.group6.domain.User;
import com.nsa.group6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJPAadptor implements UserService {


    @Autowired
    private final UserRepository userRepository;


    public UserJPAadptor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User x) {
         userRepository.save(x);
    }

    @Override
    public void updateUser(User aUser) {

    }

    @Override
    public void deleteUser(Long id) {

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserByUsername(String aName) {
        Optional<User> selectedName = userRepository.findById(aName);
        return selectedName ;
    }

    // TODO: 24/11/2020  order by tag/ orderby event type, Ukspsf element group,

//
//    @Override
//    public List<User> findUsersByMostRecent() {
//        return null;
//    }
//
//    @Override
//    public List<User> findUsersByName(String aName) {
//        return null;
//    }
//
//    @Override
//    public Optional<User> findUsersByCategory(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<User> findUsersById(Long id) {
//        return Optional.empty();
//    }
}