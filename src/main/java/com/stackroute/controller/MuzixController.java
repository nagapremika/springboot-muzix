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
    MuzixService muzixService;

    public MuzixController(MuzixService muzixService)
    {
        this.muzixService=muzixService;
    }
// Handles creation operation
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) throws TrackAlreadyExistsException
    {
        ResponseEntity responseEntity;

            muzixService.saveMuzix(muzix);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);

        return responseEntity;
    }
//Handles read operation
    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzix()

    {
        return new ResponseEntity<>(muzixService.getAllMuzix(), HttpStatus.OK);
    }
//Handles delete operation
    @DeleteMapping("muzix")
    public ResponseEntity<?> deleteMuzix(@RequestBody Muzix muzix) throws TrackNotFoundException {


            return new ResponseEntity<>(muzixService.deleteMuzix(muzix.getId()), HttpStatus.OK);

    }
//Handles update operation
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) throws TrackNotFoundException {


            return new ResponseEntity<>(muzixService.updateMuzix(muzix), HttpStatus.OK);

    }

    }
