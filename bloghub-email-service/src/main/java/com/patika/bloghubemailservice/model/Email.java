package com.patika.bloghubemailservice.model;

import com.patika.bloghubemailservice.model.enums.EmailTemplate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * 1. bloghub-email-service MongoDB bağlayın.
 */
@Document(collection = "emails")
public class Email {

    /**
     * 1. bloghub-email-service MongoDB bağlayın.
     */
    @Id
    private BigInteger id;

    @Schema(name = "to", description = "Geçerli bir email olmalıdır", example = "mbesel2005@gmail.com")
    private String to;
    @Enumerated(EnumType.STRING)
    private EmailTemplate emailTemplate;
    private String emailContent;
    private LocalDateTime createdDateTime;

    public Email(String to, EmailTemplate emailTemplate, String emailContent, LocalDateTime createdDateTime) {
        this.to = to;
        this.emailTemplate = emailTemplate;
        this.emailContent = emailContent;
        this.createdDateTime = createdDateTime;
    }
}
