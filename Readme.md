# IoT
This project is made of 3 main parts: 
 - A web server REST API aplication using Spring Boot to receive incoming commands to turn on, turn off, or to get the status of diferents IoT devices. 
 - A mosquitto broker to communicate my web app with my devices
 - Docker compose to create the services before mentioned

To run the services: 
```
docker-compose up -d
```

To shut down the containers and delete them:
```
docker-compose down
```


## Web server
In order include the .jar into docker first we need to compile the project
```
mvn clean package 
```

Then start the aplication to test it locally:
```
java -jar .\target\rest-iot-0.0.1-SNAPSHOT.jar
```

After that we should generate the image for Docker (Always standing in the same folder than Dockerfile)
```
docker build --tag=rest-iot:latest .
```

## Docker-compose
```
docker-compose build
```

```
docker-compose run
```

```
docker-compose stop
```

build & run
```
docker-compose up
```

stops all the services and cleans up the containers, networks, and images.
```
docker-compose up
```

## Mosquitto
Volumes to persist:
/mosquitto/config
/mosquitto/data
/mosquitto/log

```
sudo docker run -it -d --name mosquitto -p 1883:1883 -p 9001:9001 -v ~/Proyects/IoT/mosquitto/config/mosquitto.conf:/mosquitto/config/mosquitto.conf -v ~/Proyects/IoT/mosquitto/data:/mosquitto/data -v ~/Proyects/IoT/mosquitto/log/mosquitto.log:/mosquitto/log/mosquitto.log eclipse-mosquitto
```

Once container was created I should create a new user using the following command:
```
 docker exec -it mosquitto mosquitto_passwd -c /mosquitto/passwd_file <user_name>
```
and then type the password, and the pasword confirmation

And only after a user was created I should unncomment the following line in mosquitto.conf
```
password_file /mosquitto/passwd_file
```

and restart the container to changes take effect
```
docker restart mosquitto
```

To add more users should use 
```
docker exec -it mosquitto mosquitto_passwd -b /mosquitto/passwd_file <user_name> <password>
```

In order to run a shell inside container:
```
docker exec -it mosquitto sh 
```

To encript passwords file
```
mosquitto_passwd -U passwordfile
```

## Info to create a Bash to add devices
Look out for expect command in bash
```
#!/usr/bin/expect
set pass "mysecret"

spawn /usr/bin/passwd

expect "password: "
send "$pass"
expect "password: "
send "$pass"
```

Refer to:
 https://cedalo.com/blog/mosquitto-docker-configuration-ultimate-guide/
 https://www.baeldung.com/dockerizing-spring-boot-application
 https://www.baeldung.com/java-mqtt-client
