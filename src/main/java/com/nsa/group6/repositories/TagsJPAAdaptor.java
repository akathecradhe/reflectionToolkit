package com.nsa.group6.repositories;

import com.nsa.group6.domain.TagRead;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.repositories.TagsRepository;
import com.nsa.group6.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsJPAAdaptor implements TagsService {

    private TagsRepository tagsRepository;

    @Autowired
    public TagsJPAAdaptor(TagsRepository aTagsRepository) {
        tagsRepository = aTagsRepository;
    }
    
    @Override
    public void saveTags(Tags aTags) {

    }

    @Override
    public void updateTags(Tags aTags) {

    }

    @Override
    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }
}
