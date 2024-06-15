package uk.co.sheffieldwebprogrammer.estatesearch.userservice.model;

import lombok.Data;

@Data
public class Like {
    String userId;
    long propertyId;
}
