package com.roscalas.restiot.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AudiovisualService {

    private MqttService mqttService;

    @Value("${mqtt.topic.audiovisual}")
    private String audiovisualTopic;


    public AudiovisualService(MqttService mqttService){
        this.mqttService = mqttService;
    }

    public void turnOnAudioVisualDevices() {
        JSONObject json = new JSONObject();
        json.put("command", "on");
        mqttService.publishToTopic(audiovisualTopic, json.toString().getBytes());
    }

    public void turnOffAudioVisualDevices() {
        
    }
}