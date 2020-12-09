package com.nsa.group6.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubmittingForm {

    public Integer formID;

    public Integer eventType;

    public String eventDate;

    public String shortDesc;

    public Integer role;

    public List<Integer> others;

    public List<Integer> impact;

    public List<Integer> learningTechs;

    public List<Integer> thoughtCloud;

    public List<Integer> dimensions;

    public SubmittingForm(Integer eventType, String eventDate, String shortDesc, Integer role, List<Integer> others, List<Integer> impact, List<Integer> learningTechs, List<Integer> thoughtCloud, List<Integer> dimensions) {
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.shortDesc = shortDesc;
        this.role = role;
        this.others = others;
        this.impact = impact;
        this.learningTechs = learningTechs;
        this.thoughtCloud = thoughtCloud;
        this.dimensions = dimensions;

    }

}

