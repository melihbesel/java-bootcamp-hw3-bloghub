package com.patika.bloghubindexservice.repository;

import com.patika.bloghubindexservice.model.Exception;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends MongoRepository<Exception, String> {

}
