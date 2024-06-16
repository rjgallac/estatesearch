package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model.Property;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model.PropertyDto;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model.PropertyResults;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.repository.PropertyRepository;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("search/property")
@CrossOrigin
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping
    public void get(){
        String addresses[] = new String[]{"Johns Street", "James Road", "Windsor Drive", "St Marys Gate", "Dunree Gdns"};
        String images[] = new String[]{"home1", "home2", "home3", "home4", "home5"};
        long salaries[] = new long[]{200000l, 100000l, 300000l, 400000l, 500000l, 600000l};
        int beds[] = new int[]{1, 2, 3};

        String descriptions[] = new String[]{
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed Granny nisi auctor, placerat diam ac, consectetur mi. Fusce aliquet id est id fringilla. Pellentesque commodo laoreet odio, nec malesuada libero. Pellentesque eget lacinia massa. Pellentesque scelerisque rutrum orci, vel ornare ligula gravida quis. Integer sapien augue, pulvinar nec tortor id, elementum euismod nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque vitae lorem efficitur, dignissim lectus vitae, egestas sapien. Integer finibus pulvinar urna, vitae congue lacus. Integer efficitur pretium justo, nec fringilla lorem elementum vitae. Cras pulvinar massa ut enim ultrices laoreet. Duis sed dolor pharetra, bibendum turpis eu, euismod nisi.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed Swimming nisi auctor, placerat diam ac, consectetur mi. Fusce aliquet id est id fringilla. Pellentesque commodo laoreet odio, nec malesuada libero. Pellentesque eget lacinia massa. Pellentesque scelerisque rutrum orci, vel ornare ligula gravida quis. Integer sapien augue, pulvinar nec tortor id, elementum euismod nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque vitae lorem efficitur, dignissim lectus vitae, egestas sapien. Integer finibus pulvinar urna, vitae congue lacus. Integer efficitur pretium justo, nec fringilla lorem elementum vitae. Cras pulvinar massa ut enim ultrices laoreet. Duis sed dolor pharetra, bibendum turpis eu, euismod nisi.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed Beach nisi auctor, placerat diam ac, consectetur mi. Fusce aliquet id est id fringilla. Pellentesque commodo laoreet odio, nec malesuada libero. Pellentesque eget lacinia massa. Pellentesque scelerisque rutrum orci, vel ornare ligula gravida quis. Integer sapien augue, pulvinar nec tortor id, elementum euismod nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque vitae lorem efficitur, dignissim lectus vitae, egestas sapien. Integer finibus pulvinar urna, vitae congue lacus. Integer efficitur pretium justo, nec fringilla lorem elementum vitae. Cras pulvinar massa ut enim ultrices laoreet. Duis sed dolor pharetra, bibendum turpis eu, euismod nisi.",
        };
        for(int i=0; i<1000; i++){
            Property property = new Property();
            property.setAddress(addresses[ThreadLocalRandom.current().nextInt(0, addresses.length)]);
            property.setPrice(salaries[ThreadLocalRandom.current().nextInt(0, salaries.length)]);
            property.setDescription(descriptions[ThreadLocalRandom.current().nextInt(0, descriptions.length)]);
            property.setImage(images[ThreadLocalRandom.current().nextInt(0, images.length)]);
            property.setBedrooms(beds[ThreadLocalRandom.current().nextInt(0, beds.length)]);
            Property savedProperty = propertyRepository.save(property);

        }

    }

    @PostMapping
    public String add(@RequestBody PropertyDto propertyDto) {
        Property property = new Property();
        property.setAddress(propertyDto.getAddress());
        property.setPrice(propertyDto.getPrice());
        property.setDescription(propertyDto.getDescription());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setPropertyId(propertyDto.getId());
        property.setImage(propertyDto.getImage());
        Property savedProperty = propertyRepository.save(property);
        return savedProperty.getAddressId();

    }

    @RequestMapping("/all")
    @GetMapping
    public List<Property> listAll() {
        return propertyRepository.findByDescriptionContaining("Beach");
    }

    @RequestMapping("/price")
    @GetMapping
    public List<Property> sal() {
        Sort sortBy = Sort.by(Sort.Order.asc("price"));
        Pageable pageable = PageRequest.of(0,10, sortBy);
        return propertyRepository.findByPrice(10000l, pageable).getContent();
    }

    @RequestMapping("/pageproperty")
    @GetMapping
    public List<Property> pageproperty() {
        Sort sortBy = Sort.by(Sort.Order.asc("description"));
        Pageable pageable = PageRequest.of(0,10, sortBy);
        return propertyRepository.findByDescriptionContaining("JAVA", pageable).getContent();
    }

    @RequestMapping("searchquery")
    @GetMapping
    public ResponseEntity<PropertyResults> getProps(@RequestParam("query") String query, @RequestParam("pageNo") int pageNo,
                                                    @Nullable @RequestParam(value = "minPrice", required = false) long minPrice,
                                                    @Nullable @RequestParam(value = "bedrooms", required = false) int bedrooms) {
//        Sort sortBy = Sort.by(Sort.Order.asc("description"));
        Pageable pageable = PageRequest.of(pageNo,10);
        PropertyResults propertyResults = new PropertyResults();
//        Page<Property> propertyRepositoryByDescriptionContaining = propertyRepository.findByDescriptionContaining(query, pageable);
        Page<Property> propertyRepositoryByDescriptionContaining = propertyRepository.findByDescriptionContainingAndPriceGreaterThanEqualAndBedroomsGreaterThanEqual(query, minPrice, bedrooms, pageable);
        List<Property> properties = propertyRepositoryByDescriptionContaining.getContent();
        propertyResults.setProperties(properties);
        propertyResults.setTotalResults(propertyRepositoryByDescriptionContaining.getTotalElements());
        propertyResults.setPages(propertyRepositoryByDescriptionContaining.getTotalPages());
        return ResponseEntity.ok(propertyResults);
    }

    @DeleteMapping("/{id}")
    public void deleteFromSearch(@PathVariable("id") String id) {
        propertyRepository.deleteById(id);
    }


}
