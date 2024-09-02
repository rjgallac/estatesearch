package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.controller;

import lombok.extern.slf4j.Slf4j;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propertyinfo/propertyinfo")
@Slf4j
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
    public ResponseEntity<PropertyDto> getById(@PathVariable("id") long id) {
        Optional<Property> byId = propertyService.findById(id);
        PropertyDto dto = null;
        if(byId.isPresent()) {
            dto = propertyMapper.toDto(byId.get());
        }
//        try {
//            List<ImageUploadDto> images = imageService.getImages(id);
//            dto.setImages(images);
//        }catch (Exception e) {
//            log.error(e.getMessage());
//        }
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<PropertyDto> addProperty(@RequestBody PropertyDto propertyDto) {
        Property property = new Property();
        property.setAddress(propertyDto.getAddress());
        property.setPrice(propertyDto.getPrice());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setDescription(propertyDto.getDescription());
        property.setImage(propertyDto.getImage());
        property.setPropertyType(propertyDto.getPropertyType());
        property.setType(propertyDto.getType());
        Property save = propertyService.save(property);
        propertyDto.setId(save.getId());
        return ResponseEntity.ok(propertyDto);

    }

//    @GetMapping("/sendToSearch/{propertyId}")
//    @CrossOrigin
//    public void sendToSearch(@PathVariable("propertyId") long propertyId) {
//        Optional<Property> byId = propertyService.findById(propertyId);
//        List<ImageUploadDto> images = new ArrayList<>();
//        try {
//            images = imageService.getImages(propertyId);
//        }catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        if(byId.isPresent()) {
//            Property property = byId.get();
//            PropertyDto dto = propertyMapper.toDto(property);
//            try {
//                dto.setImage(images.getFirst().getImageSmallFilename());
//            }catch (Exception e) {
//                log.error(e.getMessage());
//            }
//            String s = searchService.sendToSearch(dto);
//            property.setSearchId(s);
//            propertyService.save(property);
//
//        }
//
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        Optional<Property> byId = propertyService.findById(id);
        if(byId.isPresent()) {
            Property property = byId.get();
            searchService.delete(property.getSearchId());
            imageService.deleteAllByPropertyId(id);
            propertyService.delete(id);
        }

    }

//    @DeleteMapping("/delete-from-search/{id}")
//    @CrossOrigin
//    public void deleteFromSearch(@PathVariable("id") long id) {
//        Optional<Property> byId = propertyService.findById(id);
//        if(byId.isPresent()) {
//            Property property = byId.get();
//            searchService.delete(property.getSearchId());
//
//        }
//
//    }

//
//
    @GetMapping
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
