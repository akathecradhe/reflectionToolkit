package com.nsa.group6.service;

import com.nsa.group6.domain.Tags;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Worked on by Brian and Clive
 */
@Service
public interface TagService {

    Tags getTagByID(int tagID);
    List<Tags> getAllTags();
    void saveTags(Tags aTags);

    public void deleteTag(int id);
    List<Tags> getTagByCategory(String category);



}
