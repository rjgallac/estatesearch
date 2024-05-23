FROM nginx:latest
COPY nginx.conf /etc/nginx/nginx.conf
# copy the built Angular app files to the default nginx html directory
COPY /dist/searchfront/browser /usr/share/nginx/html