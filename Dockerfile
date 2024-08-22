FROM openjdk:17-jdk-slim

LABEL authors="franklinokeh"

WORKDIR /app

COPY target/RemitOne.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
