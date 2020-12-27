package com.nsa.group6.repositories;

import com.nsa.group6.domain.Event;
import com.nsa.group6.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Worked on by Jay
 */
@Service
public class EventJPAAdaptor implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventJPAAdaptor(EventRepository aEventRepository) {
        eventRepository = aEventRepository;
    }
    
    @Override
    public void saveEvent(Event aEvent) {

    }

    @Override
    public void updateEvent(Event aEvent) {

    }

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEventByID(int eventID) {
        return eventRepository.findById(eventID);
    }

}
