package com.nsa.group6.repositories;

import com.nsa.group6.domain.Tags;
import com.nsa.group6.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public List<Tags> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public void saveTags(Tags aTags) {

    }

    @Override
    public void deleteTag(int id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<Tags> getTagByCategory(String category) {
        return tagRepository.findAllByCategory(category);
    }


}
