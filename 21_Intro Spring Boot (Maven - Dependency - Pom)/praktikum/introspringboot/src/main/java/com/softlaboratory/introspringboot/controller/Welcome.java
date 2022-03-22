package com.softlaboratory.introspringboot.controller;

import com.softlaboratory.introspringboot.dto.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Welcome {

    @GetMapping("/v1/messages")
    public ResponseEntity<MessageResponse> getResponses() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Ini teks response method GET ketika status OK.");

        return ResponseEntity.ok().body(messageResponse);
    }

    @PostMapping("/v1/messages")
    public ResponseEntity<MessageResponse> postResponses() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Ini teks response method POST ketika status OK.");

        return ResponseEntity.ok().body(messageResponse);
    }

    @DeleteMapping("/v1/messages")
    public ResponseEntity<MessageResponse> delResponses() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Ini teks response method DEL ketika status OK.");

        return ResponseEntity.ok().body(messageResponse);
    }
}
