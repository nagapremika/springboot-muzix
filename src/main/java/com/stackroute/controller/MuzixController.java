package com.stackroute.controller;
import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.MuzixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class MuzixController {
   private ResponseEntity responseEntity;
    private  MuzixService muzixService;
    public MuzixController(MuzixService muzixService)
    {
        this.muzixService=muzixService;
    }
    // Handles creation operation
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) throws TrackAlreadyExistsException
    {
        muzixService.saveTrack(muzix);
        responseEntity=new ResponseEntity<>("Created successfully", HttpStatus.CREATED);
        return responseEntity;
    }
    //Handles read operation
    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzix()
    {
        muzixService.getList();
        return new ResponseEntity<>(muzixService.getAllTracks(), HttpStatus.OK);
    }
    //Handles delete operation
    @DeleteMapping("muzix")
    public ResponseEntity<?> deleteMuzix(@RequestBody Muzix muzix) throws TrackNotFoundException {
        return new ResponseEntity<>(muzixService.deleteTrack(muzix.getTrackId()), HttpStatus.OK);
    }
    //Handles update operation
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) throws TrackNotFoundException {
        return new ResponseEntity<>(muzixService.updateTrack(muzix,muzix.getTrackId()), HttpStatus.OK);
    }
}



