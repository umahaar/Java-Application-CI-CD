# Use the Eclipse Temurin JRE 17 image to run the application
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the host to the container
COPY target/HelloWorldApp-1.0-SNAPSHOT.jar /app/HelloWorldApp.jar

# Expose the application port
EXPOSE 8080

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/HelloWorldApp.jar"]