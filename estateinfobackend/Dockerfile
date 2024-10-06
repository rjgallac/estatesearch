FROM openjdk:21
VOLUME /tmp
COPY build/libs/estateinfobackend-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-Dspring.profiles.active=compose","-jar","estateinfobackend-0.0.1-SNAPSHOT.jar"]