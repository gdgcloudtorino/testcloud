FROM maven:3-openjdk-17 AS builder

WORKDIR /usr/src/app
COPY pom.xml /usr/src/app
RUN mvn -B dependency:go-offline

COPY src /usr/src/app/src
RUN mvn -f /usr/src/app/pom.xml package -DskipTests

FROM openjdk:17-jdk-slim
ARG JAR_FILE=/usr/src/app/target/*.jar
COPY --from=builder ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]