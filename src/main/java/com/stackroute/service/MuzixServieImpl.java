package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuzixServieImpl implements MuzixService {      //Implements MuzixService
    @Autowired
    MuzixRepository muzixRepository;

    public MuzixServieImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    @Override       //overrides saveMuzix
    public Muzix saveMuzix(Muzix muzix) throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(muzix.getId())) {
            return muzixRepository.save(muzix);
        }
        else{
            throw new TrackAlreadyExistsException("track already exists");
        }
    }

    @Override       //overrides getAllMuzix
    public List<Muzix> getAllMuzix()
    {
        return muzixRepository.findAll();
    }

    @Override       //overrides updateMuzix
    public boolean updateMuzix(Muzix muzix) throws TrackNotFoundException {
        if(muzixRepository.existsById(muzix.getId())) {
            muzix.setId(muzix.getId());
            muzix.setName(muzix.getName());
            muzix.setTrack(muzix.getTrack());
            muzixRepository.save(muzix);
            return true;
        }
        else{
            throw new TrackNotFoundException("Track not found");
        }

    }


    @Override       //overrides deleteMuzix
    public boolean deleteMuzix(int id) throws TrackNotFoundException {
        if(muzixRepository.existsById(id)) {
            muzixRepository.deleteById(id);
            return true;
        }
        else{
            throw new TrackNotFoundException("Track not found");
        }

    }
    @Override       //overrides trackByName
    public List<Muzix> trackByName(String name) {
        Muzix muzix=new Muzix();
        muzix.setName(name);
        return muzixRepository.trackByName(muzix.getName());
    }


}
