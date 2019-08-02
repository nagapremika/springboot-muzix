package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Creates a repository by extending JpaRepository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {
    @Query("SELECT t FROM Track t WHERE name = ?1")
    List<Muzix> getTrackByName(String name);
=======
import org.springframework.stereotype.Repository;

@Repository //Repository that extends JpaRepository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {

>>>>>>> 97c2db4ee8a10d60b202a446d2c697a10b2049e1
}
