package com.patika.bloghubemailservice.controller;

import com.patika.bloghubemailservice.dto.request.EmailCreateRequest;
import com.patika.bloghubemailservice.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    @Operation(summary = "Email gönderir",
            description = "Kayıtlı kullanıcı için email göndermek için kullanılır."
    )
    public void sendEmail(@RequestBody EmailCreateRequest request){
        emailService.sendEmail(request);
    }
}
