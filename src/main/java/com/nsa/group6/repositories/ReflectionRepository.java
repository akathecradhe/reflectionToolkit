package com.nsa.group6.repositories;

import com.nsa.group6.domain.Reflection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ReflectionRepository extends JpaRepository<Reflection,Integer> {
}
