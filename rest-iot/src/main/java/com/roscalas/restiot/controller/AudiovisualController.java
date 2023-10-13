package com.roscalas.restiot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roscalas.restiot.service.AudiovisualService;

@RestController
public class AudiovisualController {

    @Autowired
    private AudiovisualService audiovisualService;

    @GetMapping("/audiovisual/turn-on")
    public ResponseEntity<String> audiovisualTurnOn() {
        audiovisualService.turnOnAudioVisualDevices();
        return ResponseEntity.ok("Turning audiovisual on");
    }

    @GetMapping("/audiovisual/turn-off")
    public ResponseEntity<String> audiovisualTurnOff() {
        audiovisualService.turnOffAudioVisualDevices();
        return ResponseEntity.ok("Turning audiovisual off");
    }
}
