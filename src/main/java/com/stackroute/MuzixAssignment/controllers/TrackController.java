package com.stackroute.MuzixAssignment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MuzixAssignment.domain.Result;
import com.stackroute.MuzixAssignment.domain.Track;
import com.stackroute.MuzixAssignment.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixAssignment.exceptions.TrackNotFoundException;
import com.stackroute.MuzixAssignment.service.TrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@ControllerAdvice(basePackages = "com.stackroute.muzixapp")
public class TrackController {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    TrackService trackService;

    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException
    {
        Track track1 = trackService.saveTrack(track);
        return new ResponseEntity<Track>(track1, HttpStatus.CREATED);
    }

    @PostMapping("alltracks")
    public ResponseEntity<?> saveTrack(@RequestBody List<Track> trackList) throws TrackAlreadyExistsException
    {
        List<Track> savedTrackList = new ArrayList<Track>();
        //saving each track
        for (Track track:trackList) {
            Track track1 = trackService.saveTrack(track);
            savedTrackList.add(track1);
        }
        return new ResponseEntity<List<Track>>(savedTrackList, HttpStatus.CREATED);
    }

    @GetMapping("trackByName")
    public ResponseEntity<?> getTrackByName(@RequestParam String name) throws TrackNotFoundException
    {
        return new ResponseEntity<List<Track>>(trackService.getTracksByName(name), HttpStatus.OK);
    }
//@Cacheable()
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        }
        catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        logger.debug("Updated Testing Spring Boot Devtools");

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return responseEntity;
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track, @PathVariable int id) throws TrackNotFoundException
    {
        Track track1 = trackService.updateTrack(track,id);
        return new ResponseEntity<Track>(track1, HttpStatus.OK);
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable int id) throws TrackNotFoundException
    {
        ResponseEntity responseEntity = null;

        Track deletedTrack = trackService.deleteTrack(id);

        if(deletedTrack != null) {
            responseEntity = new ResponseEntity<Track>(deletedTrack, HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("searchTracks")
    public ResponseEntity<?> searchTracks(@RequestParam("searchString") String searchString)
    {
        return new ResponseEntity<>(trackService.searchTracks(searchString),HttpStatus.OK);
    }

    @GetMapping("getLastFmTracks")
    public ResponseEntity<?> getLastFmTracks(@RequestParam String url) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        String string = restTemplate.getForObject(url,String.class);

        //converting json to java object
        ObjectMapper objectMapper = new ObjectMapper();
        Result result = objectMapper.readValue(string, Result.class);

        //obtain the list of tracks
        List<Track> trackList = result.results.trackmatches.track;
        List<Track> savedTrackList = new ArrayList<>();

        //save each track
        for (Track track:trackList) {
            Track track1 = trackService.saveTrack(track);
            savedTrackList.add(track1);
        }
        return new ResponseEntity<>(savedTrackList,HttpStatus.OK);
    }
}
