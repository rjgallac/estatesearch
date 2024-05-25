



docker run --detach -p3306:3306 --name some-mariadb --env MARIADB_DATABASE=estatesearch --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest
