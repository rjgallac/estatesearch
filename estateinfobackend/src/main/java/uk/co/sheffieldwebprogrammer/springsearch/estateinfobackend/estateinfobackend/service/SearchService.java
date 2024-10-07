package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.PropertyDto;

@Service
@Slf4j
public class SearchService {

    @Value("${estatesearch.searchservice}")
    private String searchService;

    RestTemplate restTemplate = new RestTemplate();

    public String sendToSearch(PropertyDto propertyDto) {
        try {
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(searchService + "/search/property/post", propertyDto, String.class);
            return stringResponseEntity.getBody();
        } catch(Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    public void delete(String id) {
        restTemplate.delete(searchService + "/search/property/" + id);

    }
}
