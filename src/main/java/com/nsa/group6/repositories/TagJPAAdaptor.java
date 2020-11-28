package com.nsa.group6.repositories;

import com.nsa.group6.domain.Tags;
import com.nsa.group6.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagJPAAdaptor implements TagService {
    @Autowired
    private final TagRepository tagRepository;

    public TagJPAAdaptor(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tags getTagByID(int tagID) {
        return tagRepository.findByTagID(tagID);
    }
}
