# Property Search App


## Architecture

![alt text](https://github.com/rjgallac/estatesearch/blob/c6c8065e1841a355955c0bb0cd980aa4f696c65b/toplevelarchitecture.drawio.png)


## Demo Video

[![Watch the video](https://img.youtube.com/vi/FXfud3NmZJ0/0.jpg)](https://youtu.be/FXfud3NmZJ0)

## Search App

Search for properties 

- SpringBoot
- Elastic search 

##  backend

- SpringBoot
- MariaDb

## Frontend

Customer facing site

- nginx
- Angular

TODO
- admin list - material table + pagination
- add analytics service - every search logged, each property viewed
- add favourite + shortlist user service
- map in admin - click for lat and long
- submit multi image on create in admin
- add property type

## Use

Eureka
http://localhost:8761/

Keycloak
docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:25.0.4 start-dev

add realm "SpringbootKeycloak"
add client "login-app" with root url "http://localhost:4200"
add user - note , need to add names and email or you'll get 400 - account not fully setup.
dont forget to add web origins - "*"  or "http://localhost:4200" for testing purposes.

http://localhost:8181/

docker build -t rjgallac/estatenginx .
