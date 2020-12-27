package com.nsa.group6.repositories;

import com.nsa.group6.domain.Reflection;
import com.nsa.group6.service.ReflectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Worked on by Jay, Tom
 */
@Service
public class ReflectionJPAAdaptor implements ReflectionService {

    private ReflectionRepository reflectionRepository;

    @Autowired
    public ReflectionJPAAdaptor(ReflectionRepository aReflectionRepository) {
        reflectionRepository = aReflectionRepository;
    }
    
    @Override
    public void saveReflection(Reflection aReflection) {

    }

    @Override
    public void updateReflection(Reflection aReflection) {

    }

    @Override
    public List<Reflection> getAllReflection() {
        return null;
    }

    @Override
    public List<Reflection> findAllReflectionByID(List<Integer> ReflectionIDs) {
        return null;
    }

    @Override
    public void save(Reflection reflectionInput) {
        reflectionRepository.save(reflectionInput);
    }

}
