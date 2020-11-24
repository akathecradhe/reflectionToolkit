package com.nsa.group6.jpa;

import com.nsa.group6.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepoJPA extends JpaRepository<Event,Integer>{
}
