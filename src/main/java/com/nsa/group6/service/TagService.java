package com.nsa.group6.service;

import com.nsa.group6.domain.Tags;
import org.springframework.stereotype.Service;

@Service
public interface TagService {

    Tags getTagByID(int tagID);
}
