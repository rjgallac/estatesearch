FROM openjdk:21
VOLUME /tmp
COPY build/libs/imageupload-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-Dspring.profiles.active=compose","-jar","imageupload-0.0.1-SNAPSHOT.jar"]