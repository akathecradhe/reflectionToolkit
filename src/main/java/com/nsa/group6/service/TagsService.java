package com.nsa.group6.service;

import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TagsService {
    public void saveTags(Tags aTags);

    public void updateTags(Tags aTags);

    Tags getTagByID(int tagID);

    List<Tags> getTagByCategory(String category);

    List<Tags> getAllTags();

    List<Tags> findAllTagsByID(List<Integer> TagIDs);
}
