package com.roscalas.restiot.configuration;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mqttConfiguration {

    @Value("${mqtt.broker.url}")
    private String mqttBrokerUrl;

    @Value("${mqtt.client.id}")
    private String mqttClientId;

    @Value("${mqtt.client.user}")
    private String mqttClientUser;

    @Value("${mqtt.client.password}")
    private char[] mqttClientPassword;
    
    @Bean
    public IMqttClient publisher() throws MqttException{
        IMqttClient publisher = new MqttClient(mqttBrokerUrl, mqttClientId);
        return publisher;
    }

    @Bean
    public MqttConnectOptions connectionOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setUserName(mqttClientUser);
        options.setPassword(mqttClientPassword);
        
        return options;
    }
}
