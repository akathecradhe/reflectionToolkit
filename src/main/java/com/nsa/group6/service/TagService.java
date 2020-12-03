package com.nsa.group6.service;

import com.nsa.group6.domain.Tags;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {

    Tags getTagByID(int tagID);
    List<Tags> getAllTags();

    List<Tags> getTagByCategory(String category);
}
