package com.oocl.web.sampleWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class Controller {

    @Autowired
    private SingleEntityRepository reposity;

    @GetMapping
    public MessageResponse get() {

        SingleEntity singleEntity = reposity.findAll().get(0);
        return new MessageResponse(singleEntity.name);
    }
}
