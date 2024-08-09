package com.patika.bloghubemailservice.repository;

import com.patika.bloghubemailservice.model.Email;
import com.patika.bloghubemailservice.model.enums.EmailTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
/**
 * 1. bloghub-email-service MongoDB bağlayın.
 */
public interface EmailRepository extends MongoRepository<Email, String> {
    List<Email> findByEmailTemplate(EmailTemplate emailTemplate);

}
