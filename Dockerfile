FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD target/task_9_2-0.0.1-SNAPSHOT.jar authorizationapp.jar