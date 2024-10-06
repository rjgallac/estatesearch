FROM openjdk:21
VOLUME /tmp
COPY build/libs/backend-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-Dspring.profiles.active=compose","-jar","backend-0.0.1-SNAPSHOT.jar"]