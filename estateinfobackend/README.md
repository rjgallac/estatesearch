docker run --detach -p3306:3306 --name some-mariadb --env MARIADB_DATABASE=estatesearch --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest

docker exec -it some-mariadb sh
mariadb -u root -p
use estatesearch;
show tables;
select * from estatesearch;
delete from property;