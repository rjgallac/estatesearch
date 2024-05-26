package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.entity.Property;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.mappers.PropertyMapper;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.ImageUploadDto;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.PropertyDto;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.PropertyResults;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service.ImageService;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service.PropertyService;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service.SearchService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propertyinfo")
public class PropertyController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private PropertyMapper propertyMapper;

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<PropertyDto> getById(@PathVariable("id") long id) {
        Optional<Property> byId = propertyService.findById(id);
        PropertyDto dto = null;
        if(byId.isPresent()) {
            dto = propertyMapper.toDto(byId.get());
        }
        List<ImageUploadDto> images = imageService.getImages(id);
        dto.setImages(images);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    @CrossOrigin
    public void addProperty(@RequestBody PropertyDto propertyDto) {
        Property property = new Property();
        property.setAddress(propertyDto.getAddress());
        property.setPrice(propertyDto.getPrice());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setDescription(propertyDto.getDescription());
        property.setImage(propertyDto.getImage());
        Property save = propertyService.save(property);
        propertyDto.setId(save.getId());

    }

    @GetMapping("/sendToSearch/{propertyId}")
    @CrossOrigin
    public void sendToSearch(@PathVariable("propertyId") long propertyId) {
        Optional<Property> byId = propertyService.findById(propertyId);
        List<ImageUploadDto> images = imageService.getImages(propertyId);
        if(byId.isPresent()) {
            Property property = byId.get();
            PropertyDto dto = propertyMapper.toDto(property);
            dto.setImage(images.getFirst().getImageSmallFilename());
            String s = searchService.sendToSearch(dto);
            property.setSearchId(s);
            propertyService.save(property);

        }

    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void delete(@PathVariable("id") long id) {
        Optional<Property> byId = propertyService.findById(id);
        if(byId.isPresent()) {
            Property property = byId.get();
            searchService.delete(property.getSearchId());
            propertyService.delete(id);
        }

    }

    @DeleteMapping("/delete-from-search/{id}")
    @CrossOrigin
    public void deleteFromSearch(@PathVariable("id") long id) {
        Optional<Property> byId = propertyService.findById(id);
        if(byId.isPresent()) {
            Property property = byId.get();
            searchService.delete(property.getSearchId());

        }

    }



    @GetMapping
    @CrossOrigin
    public ResponseEntity<PropertyResults> findPage(@RequestParam("pageNo") int pageNo) {
        Sort sortBy = Sort.by(Sort.Order.asc("description"));
        Pageable pageable = PageRequest.of(pageNo,10, sortBy);
        PropertyResults propertyResults = new PropertyResults();


        Page<Property> byPage = propertyService.findByPage(pageable);
        List<Property> properties = byPage.getContent();
        propertyResults.setProperties(properties);
        propertyResults.setTotalResults(byPage.getTotalElements());
        propertyResults.setPages(byPage.getTotalPages());
        return ResponseEntity.ok(propertyResults);
    }



}
