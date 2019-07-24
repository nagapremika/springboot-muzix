package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository //Repository that extends JpaRepository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {
    @Query("select m from Muzix m where m.name=?1")
    List<Muzix> trackByName(String name);  //Abstract method
}
