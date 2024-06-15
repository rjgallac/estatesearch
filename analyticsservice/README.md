docker run --detach -p3308:3312 --name analyticsdb --env MARIADB_DATABASE=analyticsdb --env MARIADB_ROOT_PASSWORD=my-secret-pw  mariadb:latest
