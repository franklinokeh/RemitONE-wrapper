FROM maven:3.8.3-openjdk-17 AS build
LABEL authors="franklinokeh"

WORKDIR /app

COPY . ./

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/RemitOne.jar RemitOne.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/RemitOne.jar"]
