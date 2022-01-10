FROM openjdk:11-slim

WORKDIR /usr/src/app
COPY target/demo-0.0.1-SNAPSHOT.jar /usr/src/app

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
