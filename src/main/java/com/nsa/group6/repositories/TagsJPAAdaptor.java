package com.nsa.group6.repositories;

import com.nsa.group6.domain.Tags;
import com.nsa.group6.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Worked on by Tom, Jay
 */
@Service
public class TagsJPAAdaptor implements TagsService {

    private TagsRepository tagsRepository;

    @Autowired
    public TagsJPAAdaptor(TagsRepository aTagsRepository) {
        tagsRepository = aTagsRepository;
    }
    
    @Override
    public void saveTags(Tags aTags) {

        tagsRepository.save(aTags);

    }

    @Override
    public void updateTags(Tags aTags) {
        tagsRepository.save(aTags);

    }
    @Override
    public Tags getTagByID(int tagID) {
        return tagsRepository.findByTagID(tagID);
    }


    @Override
    public List<Tags> getTagByCategory(String category) {
        return tagsRepository.findAllByCategory(category);
    }

    @Override
    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }

    @Override
    public List<Tags> findAllTagsByID(List<Integer> TagIDs) {
        return tagsRepository.findAllById(TagIDs);
    }
}


