package com.unito.testcloud.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseResource {
    @GetMapping
    public ResponseEntity<Void> get(){
        return ResponseEntity.ok(null);
    }
}
