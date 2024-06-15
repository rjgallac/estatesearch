docker run --detach -p3310:3306 --name userservicedb --env MARIADB_DATABASE=userservicedb --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest


docker exec -it userservicedb sh

use userservicedb;
mariadb -u root -p

select * from user_like;
