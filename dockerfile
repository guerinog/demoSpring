FROM maven:3.5-jdk-8-alpine AS build

COPY src /usr/src/demoSpring/src
COPY pom.xml /usr/src/demoSpring
RUN mvn -f /usr/src/demoSpring/pom.xml clean package

FROM openjdk:8-jre-alpine
COPY --from=build /usr/src/demoSpring/target/demoSpring-0.0.1-SNAPSHOT.jar /usr/demoSpring/demoSpring-0.0.1-SNAPSHOT.jar  

EXPOSE 8181
ENTRYPOINT ["java", "-jar", "usr/demoSpring/demoSpring-0.0.1-SNAPSHOT.jar"]
