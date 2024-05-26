docker run --detach -p3308:3306 --name imagedb --env MARIADB_DATABASE=imagedb --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest
