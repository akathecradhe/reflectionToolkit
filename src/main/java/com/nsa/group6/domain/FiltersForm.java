package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltersForm {

    public List<Integer> tags;
    public List<String> completionStatus;

}
