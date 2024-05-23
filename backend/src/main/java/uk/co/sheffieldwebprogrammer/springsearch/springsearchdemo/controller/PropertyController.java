package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model.Property;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.repository.PropertyRepository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("property")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping
    public void get(){
        String addresses[] = new String[]{"Johns Street", "James Road", "Windsor Drive", "St Marys Gate", "Dunree Gdns"};
        long salaries[] = new long[]{20000l, 10000l};
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
            Property savedProperty = propertyRepository.save(property);

        }

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

    @CrossOrigin
    @RequestMapping("searchquery")
    @GetMapping
    public List<Property> getProps(@RequestParam String query) {
//        Sort sortBy = Sort.by(Sort.Order.asc("description"));
        Pageable pageable = PageRequest.of(0,10);
        return propertyRepository.findByDescriptionContaining(query, pageable).getContent();
    }

}
