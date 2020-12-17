package com.nsa.group6.repositories;

import com.nsa.group6.domain.ActionPoints;
import com.nsa.group6.domain.Event;
import com.nsa.group6.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface APRepository extends JpaRepository<ActionPoints,Integer> {
    List<ActionPoints> findAllByUsername(User aUsername, Sort lastEdited);
}
