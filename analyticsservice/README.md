docker run --detach -p3312:3306 --name analyticsdb --env MARIADB_DATABASE=analyticsdb --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest
