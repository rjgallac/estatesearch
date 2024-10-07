package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.ImageUploadDto;

import java.util.List;

@Service
public class ImageService {

    @Value("${estateimage.imageservice}")
    private String imageService;

    RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<List<ImageUploadDto>> exchange;

    public List<ImageUploadDto> getImages(long id) {
        exchange = restTemplate.exchange(imageService + "/imageupload/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<List<ImageUploadDto>>() {
        });
        return exchange.getBody();
    }

    public void deleteAllByPropertyId(long id) {
        restTemplate.delete(imageService + "/adminimageupload/deletebypropertyid/" + id);

    }
}
