package com.nsa.group6.service;

import com.nsa.group6.domain.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {
    public void saveEvent(Event aEvent);

    public void updateEvent(Event aEvent);

    List<Event> getAllEvent();

    Optional<Event> getEventByID(int eventID);


}
