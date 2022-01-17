FROM openjdk

WORKDIR /app

COPY target/email-service.jar email-service.jar

ENTRYPOINT ["java", "-jar", "email-service.jar"]

EXPOSE 8080