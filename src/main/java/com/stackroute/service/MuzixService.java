package com.stackroute.service;

import com.stackroute.domain.Muzix;

import java.util.List;

public interface MuzixService {     //Interface MuzixService
    public Muzix saveMuzix(Muzix muzix);
    public List<Muzix> getAllMuzix();
    public boolean updateMuzix(Muzix muzix);
    public boolean deleteMuzix(int muzoxId);
    public List<Muzix> trackByName(String name);
}
