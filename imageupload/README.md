docker run --detach -p3308:3306 --name imagedb --env MARIADB_DATABASE=imagedb --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest

docker exec -it imagedb sh
mariadb -u root -p
use imagedb;
show tables;
select * from image_upload;