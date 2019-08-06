package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public interface MuzixService {     //Interface MuzixService
    public Muzix saveMuzix(Muzix muzix) throws TrackAlreadyExistsException;
    public List<Muzix> getAllMuzix();
    public Muzix updateMuzix(Muzix muzix) throws TrackNotFoundException;
    public Muzix deleteMuzix(int muzoxId) throws TrackNotFoundException;
    
}
