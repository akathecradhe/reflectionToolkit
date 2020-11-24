package com.nsa.group6.jpaservice;

import com.nsa.group6.domain.Event;
import com.nsa.group6.domain.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormRepoJPA extends JpaRepository<Form,Integer>{


}
