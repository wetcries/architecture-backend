FROM openjdk:16
WORKDIR /usr/src/myapp
COPY ./target/backend-0.0.1-SNAPSHOT.jar .
COPY prod_application.yaml ./config/application.yaml
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]