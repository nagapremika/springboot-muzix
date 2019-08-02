package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Creates a repository by extending MongoRepository
public interface MuzixRepository extends MongoRepository<Muzix,Integer> {

}
