# HelloWorld Java Application

A simple Java web application that responds with "Hello, World!" when accessed. This application is built using Maven and can be deployed on Kubernetes.

## Features
- Simple HTTP server that responds with "Hello, World!"
- Dockerized for easy deployment
- Kubernetes and ingress deployment and service configuration provided

## Prerequisites
- Java 17 or later
- Maven 3.9.6 or later
- Docker
- Kubernetes (Tested on OCI Kubernetes Engine - OKE)
- Domain (Enter your domain name in deployment file without domain name ingress won't work)

## Build and Run Locally

### 1. Clone the Repository
```bash
git clone <repository-url>
cd HelloWorldApp
```

### 2. Build the Application
```bash
mvn install
```

### 3. Run the Application
```bash
java -jar target/HelloWorldApp-1.0-SNAPSHOT.jar
```

## Dockerize the Application

### 1. Build Docker Image
```bash
docker build . -t java
```

### 2. Run Docker Container
```bash
docker run -d -p 8080:8080 --name java-app java
```

### Access the Application:
Open your browser (if you are running docker on your local machine) and navigate to:
```
http://localhost:8080
```

## Deploy on Kubernetes

### 1. Apply Kubernetes Manifests
```bash
kubectl apply -f deployment.yaml
```

### 3. Access the Application via Ingress
Make sure your domain is set up correctly. Access your application at:
```
http://domain.com/java
```

## Cleaning Up
To remove the deployment from Kubernetes:
```bash
kubectl delete deployment helloworldapp
kubectl delete service helloworldapp-service
kubectl delete ingress helloworldapp-ingress
```

## License
This project is licensed under the MIT License.

---

This README provides all the necessary steps for someone to understand, build, run, and deploy the application, ensuring a smooth experience. Adjust any placeholders like `<repository-url>` and `<your-registry>` as needed. Let me know if you want any changes!
