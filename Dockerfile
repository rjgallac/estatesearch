FROM nginx:1.27.1
COPY nginx.conf /etc/nginx/nginx.conf
# copy the built Angular app files to the default nginx html directory
COPY adminfront/dist/adminfront/browser /usr/share/nginx/adminfront
COPY searchfront/dist/searchfront/browser /usr/share/nginx/html