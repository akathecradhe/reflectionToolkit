package com.nsa.group6.repositories;

import com.nsa.group6.domain.Tags;
import com.nsa.group6.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tags,Integer> {

    Tags findByTagID(int aTagId);

    List<Tags> findAll();

    List<Tags> findAllByCategory(String category);


}
