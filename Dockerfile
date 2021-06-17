# FROM openjdk:11.0.11-jre-slim
FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} metrics.jar
ENTRYPOINT ["java","-jar","/metrics.jar"]
