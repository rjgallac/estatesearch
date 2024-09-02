https://howtodoinjava.com/spring-data/elasticsearch-with-spring-boot-data/

https://dev.to/jmlw/spring-data-elasticsearch-and-geopoints-21dm


docker run --name elasticsearch-property -d -p 9200:9200 -p 9300:9300 \
-e "discovery.type=single-node" -e "xpack.security.enabled=false" \
docker.elastic.co/elasticsearch/elasticsearch:8.10.4

curl -X PUT "localhost:9200/property?pretty"


http://localhost:9200/_aliases

http://localhost:9200/_stats/indexing/?pretty=true

http://localhost:9200/property/_stats?pretty=true

http://localhost:9200/property/_search

http://localhost:9200/property/_search?q=description:beach

run this to generate lots of random data
http://localhost:8080/property

run this to query all those cvs that contain JAVA keyword
http://localhost:8080/property/all

curl -X DELETE "localhost:9200/property/_doc/lQFwto8Bglzi8IgTrkHi"

## docker instructions
docker build -t rjgallac/searchapp .
docker run -p8080:8080 --network host rjgallac/searchapp