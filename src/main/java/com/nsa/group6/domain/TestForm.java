package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
public class TestForm {
    private String eventName;
    private String shortDescription;
    private String eventDate;
    private String lastUpdated;

}
