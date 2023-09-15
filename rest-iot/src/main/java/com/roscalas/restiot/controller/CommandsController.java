package com.roscalas.restiot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommandsController {
    @GetMapping("/audiovisual/turn-on")
    public ResponseEntity<String> audiovisualTurnOn() {
        return ResponseEntity.ok("Audiovisual turned on...");
    }
}
