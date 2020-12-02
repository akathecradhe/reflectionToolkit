package com.nsa.group6.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubmittingForm {

    public Integer formID;

    public Integer eventType;

    public String shortDesc;

    public Integer role;

    public List<Integer> others;

    public List<Integer> impact;

    public List<Integer> learningTechs;

    public List<Integer> thoughtCloud;

    public String box1;

    public String box2;

    public String box3;

    public String box4;

    public String box5;

    public String box6;

    public String learningPoint1;

    public String learningPoint2;

    public String learningPoint3;

    public SubmittingForm(Integer eventType, String shortDesc, Integer role, List<Integer> others, List<Integer> impact, List<Integer> learningTechs, List<Integer> thoughtCloud, String box1, String box2, String box3, String box4, String box5, String box6, String learningPoint1, String learningPoint2, String learningPoint3) {
        this.eventType = eventType;
        this.shortDesc = shortDesc;
        this.role = role;
        this.others = others;
        this.impact = impact;
        this.learningTechs = learningTechs;
        this.thoughtCloud = thoughtCloud;
        this.box1 = box1;
        this.box2 = box2;
        this.box3 = box3;
        this.box4 = box4;
        this.box5 = box5;
        this.box6 = box6;
        this.learningPoint1 = learningPoint1;
        this.learningPoint2 = learningPoint2;
        this.learningPoint3 = learningPoint3;
    }

}

