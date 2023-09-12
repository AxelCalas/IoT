# IoT
This project is made of 3 main parts: 
 - A web server REST API aplication using Spring Boot to receive incoming commands to turn on, turn off, or to get the status of diferents IoT devices. 
 - A mosquitto broker to communicate my web app with my devices
 - Docker compose to create the services before mentioned
 
 ## Web server
 In order include the .jar into docker first we need to compile the project
´´´
mvn clean package 
´´´

Then start the aplication:
java -jar target/docker-message-server-1.0.0.jar


Refer to:
 https://www.baeldung.com/dockerizing-spring-boot-application
 https://www.baeldung.com/java-mqtt-client
