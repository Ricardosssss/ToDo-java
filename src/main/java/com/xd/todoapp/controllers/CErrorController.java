package com.xd.todoapp.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CErrorController implements ErrorController {

    @GetMapping("/error")
    public ResponseEntity<HttpStatus> error() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
