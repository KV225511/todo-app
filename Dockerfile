# Use official OpenJDK image
FROM openjdk:17-alpine

# Set working directory inside container
WORKDIR /app

# Copy built JAR file into container
COPY target/todo-app-1.0-SNAPSHOT.jar app.jar

# Default command to run app
ENTRYPOINT ["java", "-jar", "app.jar"]
