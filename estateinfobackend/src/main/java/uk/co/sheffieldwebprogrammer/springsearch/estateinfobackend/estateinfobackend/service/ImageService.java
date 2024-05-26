package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.ImageUploadDto;

import java.util.List;

@Service
public class ImageService {

    RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<List<ImageUploadDto>> exchange;

    public List<ImageUploadDto> getImages(long id) {
        exchange = restTemplate.exchange("http://localhost:8084/imageupload/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<List<ImageUploadDto>>() {
        });
        return exchange.getBody();
    }

    public void delete(long id) {
        restTemplate.delete("http://localhost:8084/imageupload/" + id);

    }
}
