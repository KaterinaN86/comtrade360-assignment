Comtrade360 Assignment
======================

##Internship assignment Spring Boot project

# Build the application
```docker build -t assignment:latest``` .
# Run the application
```docker run -it -p 8080:8080 assignment:latest```
# Run with a different profile
```Comment out #spring.profiles.active=api in application.properties```
# Build the docker image
```docker pull postgres:alpine```
# Run the docker image
```docker run --name some-postgres -e POSTGRES_PASSWORD=password -d -p:5432:5432 postgres:alpine```