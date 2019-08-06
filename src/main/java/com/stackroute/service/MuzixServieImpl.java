package com.stackroute.service;
import com.stackroute.domain.Muzix;
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
    public Muzix saveMuzix(Muzix muzix) {
    return muzixRepository.save(muzix);
    }

    @Override       //overrides getAllMuzix
    public List<Muzix> getAllMuzix()
    {
        return muzixRepository.findAll();
    }

    @Override       //overrides updateMuzix
    public Muzix updateMuzix(Muzix muzix) {
        muzix.setId(muzix.getId());
        muzix.setName(muzix.getName());
        muzix.setTrack(muzix.getTrack());
        return muzixRepository.save(muzix);     
   }

    @Override       //overrides deleteMuzix
    public Muzix deleteMuzix(int id) {
        return muzixRepository.deleteById(id);     
    }
}
