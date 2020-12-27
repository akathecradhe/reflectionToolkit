package com.nsa.group6.service;

import com.nsa.group6.domain.Reflection;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Worked on by Tom
 */
@Service
public interface ReflectionService {
    public void saveReflection(Reflection aReflection);

    public void updateReflection(Reflection aReflection);

    List<Reflection> getAllReflection();

    List<Reflection> findAllReflectionByID(List<Integer> ReflectionIDs);

    public void save(Reflection reflectionInput);
}
