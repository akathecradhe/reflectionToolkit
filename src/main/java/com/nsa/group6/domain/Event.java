package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int eventid;
    private String event;
    private String description;
    private String role;

    // To be implemented when we have covered many to manys.
//    @ManyToMany
//    private OtherInvolved otherInvolved;
//    @ManyToMany
//    private Impact impact;
//    @ManyToMany
//    private LearningTechnology learningTechnology;
//    @ManyToMany
//    private ThoughtCloud thoughtCloud;
//    @OneToOne
//    @JoinColumn(name = "reflection", referencedColumnName = "reflectionid")
//    private Reflection reflection
//    @ManyToMany
//    private UKPSFDimension ukpsfDimension;
    private boolean isPrivate;
    @ManyToOne
    @JoinColumn(name="username")
    private User username;




}
