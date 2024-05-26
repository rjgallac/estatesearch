package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
