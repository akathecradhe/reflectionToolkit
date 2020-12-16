package com.nsa.group6.service;

import com.nsa.group6.domain.ActionPoints;
import com.nsa.group6.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface APService {
    public void saveAction(ActionPoints aAction);

    public void updateAction(ActionPoints aAction);

    List<ActionPoints> getAllActionsByUsername(User username);

    List<ActionPoints> getRecent(User Username);

    Optional<ActionPoints> getActionByID(int actionID);


}
