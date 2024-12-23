# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file to the container
COPY target/HelloWorldApp-1.0-SNAPSHOT.jar /app/app.jar

#Copy the static asset to the cotainer
COPY src/main/resources/static/umair.png  src/main/resources/static/umair.png

# Expose the port your app listens on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "/app/app.jar"]