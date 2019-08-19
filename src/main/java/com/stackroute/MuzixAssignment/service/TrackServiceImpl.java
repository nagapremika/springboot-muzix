package com.stackroute.MuzixAssignment.service;

import com.stackroute.MuzixAssignment.domain.Track;
import com.stackroute.MuzixAssignment.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixAssignment.exceptions.TrackNotFoundException;
import com.stackroute.MuzixAssignment.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService, ApplicationListener<ContextRefreshedEvent> {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }

        Track savedTrack = trackRepository.save(track);

        if(savedTrack == null)
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {

        return trackRepository.findAll();
    }

    @Override
    public List<Track> getTracksByName(String name) {

        return trackRepository.getTrackByName(name);
    }

    public Track updateTrack(Track track, int id) throws TrackNotFoundException
    {
        Optional<Track> track1 = trackRepository.findById(id);

        if(!track1.isPresent())
        {
            throw new TrackNotFoundException("Track Not Found");
        }

        track.setId(id);

        return trackRepository.save(track);
    }

    public Track deleteTrack(int id) throws TrackNotFoundException
    {
        Optional<Track> track1 = trackRepository.findById(id);

        if(!track1.isPresent())
        {
            throw new TrackNotFoundException("Track Not Found");
        }

        try {

            trackRepository.delete(track1.get());

            return track1.get();

        }
        catch (Exception exception)
        {
            return null;
        }
    }

    @Override
    public List<Track> searchTracks(String searchString) {

        return trackRepository.searchTracks(searchString);
    }

    //Prefill Database
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        trackRepository.save(new Track(1,"Rama Rama krsihna Krishna","Ram","youtube","stream",212));
        trackRepository.save(new Track(1,"Mantra","charmi","youtube","stream",21));
    }
}
