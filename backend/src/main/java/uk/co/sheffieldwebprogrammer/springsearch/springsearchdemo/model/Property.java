package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

import java.time.LocalDate;

@Data
@Document(indexName = "property", createIndex = true)
public class Property {

    @Id
    private String addressId;

    private long propertyId;

    @Field(type = FieldType.Text, name = "address")
    private String address;

    @Field(type = FieldType.Long, name = "price")
    private long price;

    @Field(type = FieldType.Date, name = "datePosted")
    private LocalDate datePosted;

    @Field(type = FieldType.Text, name = "propertyType")
    private String propertyType;

    @Field(type = FieldType.Text, name = "type")
    private String type;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field(type = FieldType.Integer, name = "bedrooms")
    private int bedrooms;

    @Field(type = FieldType.Integer, name = "bathrooms")
    private int bathrooms;

    @Field(type = FieldType.Text, name = "image")
    private String image;

    @GeoPointField
    private double[] locationAsArray;



    // setters and getters
}