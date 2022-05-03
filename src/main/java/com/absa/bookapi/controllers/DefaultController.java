package com.absa.bookapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class DefaultController {

    @GetMapping("/")
    ResponseEntity<Void> redirectGui() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("https://absa-test.kainode.com/home/"))
                .build();
    }

    @GetMapping("/swagger")
    ResponseEntity<Void> redirectSwagger() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("https://absa-test.kainode.com/swagger-ui.html#/"))
                .build();
    }

    @GetMapping("/zen")
    ResponseEntity<Void> healthCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
