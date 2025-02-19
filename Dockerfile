# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .

# Cache dependencies to speed up builds
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Verify if the JAR file is created
RUN ls -l target/

# Stage 2: Run the application using a lightweight JDK image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 80

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
