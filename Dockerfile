# Use Maven with OpenJDK 17 for the build stage
FROM maven:3.8.3-openjdk-17 AS build
LABEL authors="franklinokeh"

# Set the working directory
WORKDIR /app

# Copy the entire project into the container
COPY . ./

# Build the application, skipping tests
RUN mvn clean package -DskipTests

# Use OpenJDK 17 for the runtime stage
FROM openjdk:17-jdk-slim

# Copy the JAR file from the build stage
COPY --from=build /app/target/RemitOne.jar RemitOne.jar

# Expose the application port
EXPOSE 8080

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "/RemitOne.jar"]
