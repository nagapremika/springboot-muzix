package com.stackroute.domain;

<<<<<<< HEAD

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
>>>>>>> 97c2db4ee8a10d60b202a446d2c697a10b2049e1
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
<<<<<<< HEAD
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//Using lombok to create setters and getters
public class Muzix {
    @Id //primary key
    private int trackId;

    private String trackName;

    private String comments;
=======
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


>>>>>>> 97c2db4ee8a10d60b202a446d2c697a10b2049e1
}
