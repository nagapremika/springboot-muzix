package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("application.properties")
public class MuzixServieImpl implements MuzixService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner
{      //Implements MuzixService
    @Value("${muzix.1.name:default}")
    String name1;                               //Using @value to fetch values from application.properties
    @Value("${muzix.1.track:default}")
    String track1;

    @Value("${muzix.2.name:default}")
    String name2;
    @Value("${muzix.2.track:default}")
    String track2;

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



    @Override       //overriding run()
    public void run(String... args) throws Exception {
        System.out.println("command line running before application starts");

    }

    @Override       //Overriding onApplicationEvent
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        muzixRepository.save(new Muzix(1, name1, track1));
        muzixRepository.save(new Muzix(2, name2, track2));
    }
}
