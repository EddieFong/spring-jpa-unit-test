package com.oocl.web.sampleWebApp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class Controller {

    @GetMapping
    public ResponseEntity<String> returnMsg() {

        return ResponseEntity.ok(null);
    }
}
