package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model;


import lombok.Data;

import java.util.List;

@Data
public class PropertyResults {
    List<Property> properties;
    long totalResults;
    int pages;
}
