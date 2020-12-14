package com.nsa.group6.api;

import com.nsa.group6.domain.FormHandler;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.domain.User;
import com.nsa.group6.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class FormApi {

    private UserService userService;
    private FormHandler formHandler;

    public FormApi(UserService userService, FormHandler formHandler) {
        this.userService = userService;
        this.formHandler = formHandler;
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> ausername = userService.findUserByUsername(userDetails.getUsername());
        User aUser = ausername.get();
        return aUser;
    }


    @GetMapping("ukpsfCount")
    public ResponseEntity<HashMap> getUKPSF() {
        User aUser = getCurrentUser();
        HashMap<Tags,Integer> ukpsfStats = formHandler.findAllUKPSFStats(aUser);
        HashMap<String,Integer> graphData = new HashMap<>();
        for (Map.Entry<Tags, Integer> entry : ukpsfStats.entrySet()) {
            graphData.put(entry.getKey().getShortenedTag(),entry.getValue());
        }
        return ResponseEntity.ok(graphData);
    }
}
