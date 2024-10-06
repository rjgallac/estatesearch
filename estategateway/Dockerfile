FROM openjdk:21
COPY build/libs/estategateway-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar","-Dspring.profiles.active=compose", "estategateway-0.0.1-SNAPSHOT.jar"]