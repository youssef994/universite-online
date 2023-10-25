FROM openjdk:17
EXPOSE 8761
ADD target/discoveryService.jar discoveryService.jar
ENTRYPOINT ["java", "-jar","discoveryService.jar"]