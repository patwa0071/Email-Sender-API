package com.email.controller;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;
    //api to end email
    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        System.out.println(request);
        boolean result=this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());

        if(result){
            return ResponseEntity.ok(new EmailResponse("Email Sent Successfully..."));
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not Sent..."));
        }

    }
}
