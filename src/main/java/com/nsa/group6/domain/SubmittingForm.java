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

    public Integer eventType;

    public String shortDesc;

    public Integer role;

    public List<Integer> others;

    public List<Integer> impact;

    public List<Integer> learningTechs;

    public List<Integer> thoughtCloud;

    public String thoughtDesc;

    public String box1;

    public String box2;

    public String box3;

    public String box4;

    public String box5;

    public String box6;

    public String learningPoint1;

    public String learningPoint2;

    public String learningPoint3;



}

