package com.roscalas.restiot.service;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttService {
    @Autowired
    private IMqttClient publisher;

    @Autowired
    private MqttConnectOptions connectionOptions;

    public void publishToTopic(String topic, byte[] payload) {
        connectIfNotConnected();
        
        try {
            publisher.publish(topic, payload, 2, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    
    public void connectIfNotConnected() {
        if(!publisher.isConnected()) {
            try {
                publisher.connect(connectionOptions);
            } catch (MqttSecurityException e) {
                e.printStackTrace();
            } catch (MqttException e) {
                e.printStackTrace();
            }

            System.out.println("connected");
        }
    }
}