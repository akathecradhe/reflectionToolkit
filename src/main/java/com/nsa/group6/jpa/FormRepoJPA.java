package com.nsa.group6.jpa;

import com.nsa.group6.domain.Event;
import com.nsa.group6.domain.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormRepoJPA extends JpaRepository<Tags,Integer> {
}
