package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.PropertyDto;

@Service
@Slf4j
public class SearchService {

    RestTemplate restTemplate = new RestTemplate();

    public String sendToSearch(PropertyDto propertyDto) {
        try {
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://127.0.0.1:8080/property", propertyDto, String.class);
            return stringResponseEntity.getBody();
        } catch(Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    public void delete(String id) {
        restTemplate.delete("http://127.0.0.1:8080/property/" + id);

    }
}
