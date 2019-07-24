package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Muzix {    //Creates an entity Muzix
    @Id
    private int id;
    private String name;
    private String track;
//Parameterized constructor
    public Muzix(int id, String name, String track) {
        this.id = id;
        this.name = name;
        this.track = track;
    }
//Default constructor
    public Muzix() {
    }
//setters and getters
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }


}
