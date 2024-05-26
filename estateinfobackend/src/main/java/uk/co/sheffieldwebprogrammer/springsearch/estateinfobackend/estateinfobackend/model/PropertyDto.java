package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PropertyDto {

    private long id;
    private String address;
    private long price;
    private LocalDate datePosted;
    private String propertyType;
    private String description;
    private int bedrooms;
    private int bathrooms;
    private String image;
    private double[] locationAsArray;
}
