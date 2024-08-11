package com.patika.bloghubemailservice.controller;

import com.patika.bloghubemailservice.model.enums.EmailTemplate;
import com.patika.bloghubemailservice.service.EmailTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/email-templates")
public class EmailTemplateController {

    private final EmailTemplateService emailTemplateService;

    @PostMapping("/{email-template}")
    @Operation(summary = "Email şablonu oluşturur",
            description = "Email gönderilirken gereken email şablonunu oluşturmak için kullanılır."
    )
    public EmailTemplate createTemplate(@PathVariable("email-template") EmailTemplate emailTemplate,
                                        @RequestBody String templateContent) {
        return emailTemplateService.createTemplate(emailTemplate, templateContent);
    }

}
