FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/HelloWorldApp-1.0-SNAPSHOT.jar /app/HelloWorldApp.jar
COPY src/main/resources/static/umair.png /app/umair.png
EXPOSE 8080
ENTRYPOINT ["java", "-cp", "/app/HelloWorldApp.jar", "com.example.HelloWorldApp"]
