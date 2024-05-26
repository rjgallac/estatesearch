package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.PropertyDto;

@Service
@Slf4j
public class SearchService {

    RestTemplate restTemplate = new RestTemplate();

    public void sendToSearch(PropertyDto propertyDto) {
        try {
            restTemplate.postForEntity("http://127.0.0.1:8080/property", propertyDto, String.class);
        } catch(Exception e){
            log.error(e.getMessage());
        }
    }
}
