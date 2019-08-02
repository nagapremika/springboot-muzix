package com.stackroute.service;

import com.stackroute.domain.Muzix;
<<<<<<< HEAD
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public interface MuzixService { //interface with method declarations
    Muzix saveTrack(Muzix muzix);
    List<Muzix> getAllTracks();
    List<Muzix> deleteTrack(int trackId);
    Muzix updateTrack(Muzix muzix,int id) throws TrackNotFoundException;
     void getList();
    public List<Muzix> getTracksByName(String name);

=======

import java.util.List;

public interface MuzixService {     //Interface MuzixService
    public Muzix saveMuzix(Muzix muzix);
    public List<Muzix> getAllMuzix();
    public boolean updateMuzix(Muzix muzix);
    public boolean deleteMuzix(int muzoxId);
>>>>>>> 97c2db4ee8a10d60b202a446d2c697a10b2049e1
}
