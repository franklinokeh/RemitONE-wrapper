FROM  openjdk:17-jdk-slim AS build
LABEL authors="franklinokeh"

WORKDIR /app

COPY . ./
RUN mvn clean package -DskipTests

FROM maven:3.8.3-openjdk-8
COPY --from=build /app/target/RemitOne.jar RemitOne.jar

ENTRYPOINT ["java","-jar","/RemitOne.jar"]
EXPOSE 80
