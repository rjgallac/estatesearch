package uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.model;

import lombok.Data;

@Data
public class SearchRequest {

    String terms;

    long minPrice;

    long maxPrice;

    long beds;
}
