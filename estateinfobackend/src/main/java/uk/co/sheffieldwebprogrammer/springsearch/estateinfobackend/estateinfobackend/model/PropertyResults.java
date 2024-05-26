package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model;

import lombok.Data;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.entity.Property;

import java.util.List;

@Data
public class PropertyResults {
    List<Property> properties;
    long totalResults;
    int pages;
}
