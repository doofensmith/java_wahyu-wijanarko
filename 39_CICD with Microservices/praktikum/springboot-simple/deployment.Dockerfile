#import base JDK from Linux
FROM adoptopenjdk/openjdk11:alpine

# working directory
WORKDIR /app

# copy application file
ARG JAR_FILE='./39_CICD with Microservices/praktikum/springboot-simple/target/*.jar'
COPY ${JAR_FILE} app.jar

# expose port
EXPOSE 8080

# run application
ENTRYPOINT ["java","-jar","/app.jar"]