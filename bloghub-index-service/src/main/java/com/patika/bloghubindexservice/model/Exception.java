package com.patika.bloghubindexservice.model;

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
@Document(collection = "exceptions")
public class Exception {

    @Id
    private BigInteger id;

    private String message;
    private LocalDateTime createdDateTime;

    public Exception(String message, LocalDateTime createdDateTime) {
        this.message = message;
        this.createdDateTime = createdDateTime;
    }
}
