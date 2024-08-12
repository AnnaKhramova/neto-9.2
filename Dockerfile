FROM bardiir/jdk22-ant:latest

EXPOSE 8080

ADD target/task_9_2-0.0.1-SNAPSHOT.jar authorizationapp.jar

CMD ["java", "-jar", "authorizationapp.jar"]