FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/RemitOne.jar RemitOne.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/RemitOne.jar"]
