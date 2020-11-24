package com.nsa.group6.jpaservice;

import com.nsa.group6.domain.Event;

import com.nsa.group6.domain.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FormJPAadptor implements FormService {


    @Autowired
    private final FormRepoJPA formRepoJPA;


    public FormJPAadptor(FormRepoJPA formRepoJPA) {
        this.formRepoJPA = formRepoJPA;
    }

    @Override
    public void saveEvent(Event aEvent) { formRepoJPA.save(aEvent);
    }

    @Override
    public void updateEvent(Event aEvent) {

    }

    @Override
    public void deleteEvent(Long id) {

    }

    @Override
    public List<Event> getAllEvents() {
        return formRepoJPA.findAll();
    }

    // TODO: 24/11/2020  order by tag/ orderby event type, Ukspsf element group,


    @Override
    public List<Event> findEventsByMostRecent() {
        return null;
    }



    @Override
    public List<Event> findEventsByName(String aName) {
        return null;
    }


    public Optional<Event> findEventsByCategory(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Event> findEventsById(Long id) {
        return Optional.empty();
    }
}
