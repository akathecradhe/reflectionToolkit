package com.nsa.group6.domain;

import java.util.List;
import java.util.Optional;

public interface FormService {
    public void saveEvent(Event aEvent);

    public void updateEvent(Event aEvent);

    public void deleteEvent(Long id);

    List<Event> getAllEvents();

    public List<Event> findEventsByMostRecent();

    public List<Event> findEventsByName(String aName);

    public Optional<Event> findEventsById(Long id);
    
}
