package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PropertyDto {

    private long id;
    private String address;
    private long price;
    private LocalDate datePosted;
    private String type;
    private String propertyType;
    private String description;
    private int bedrooms;
    private int bathrooms;
    private String image;
    private double[] locationAsArray;
    private String searchId;
    List<ImageUploadDto> images;
}
