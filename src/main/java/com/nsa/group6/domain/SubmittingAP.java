package com.nsa.group6.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Worked on by Jay
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubmittingAP {

    public List<Integer> actionpoints;

}

