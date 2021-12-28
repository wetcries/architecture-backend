FROM openjdk:16
WORKDIR /usr/src/myapp
COPY ./target/backend-0.0.1-SNAPSHOT.jar .
COPY ./application.yaml ./config/
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]