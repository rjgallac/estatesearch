package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.entity.Property;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.PropertyDto;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service.PropertyService;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service.SearchService;

@RestController
@RequestMapping("/propertyinfo")
public class PropertyController {

    @GetMapping("/{id}")
    @CrossOrigin
    public String getById(@PathVariable("id") String id) {
        return "{}";
    }

    @Autowired
    private SearchService searchService;

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public void addProperty(@RequestBody PropertyDto propertyDto) {
        Property property = new Property();
        property.setAddress(propertyDto.getAddress());
        property.setPrice(propertyDto.getPrice());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setDescription(propertyDto.getDescription());
        property.setImage(propertyDto.getImage());
        Property save = propertyService.save(property);
        propertyDto.setId(save.getId());
        searchService.sendToSearch(propertyDto);

    }


}
