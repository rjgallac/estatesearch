package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.mappers;

import org.springframework.stereotype.Component;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.entity.Property;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.PropertyDto;

@Component
public class PropertyMapper {

    public PropertyDto toDto(Property property) {
        return PropertyDto.builder()
                .id(property.getId())
                .address(property.getAddress())
                .price(property.getPrice())
                .bedrooms(property.getBedrooms())
                .description(property.getDescription())
                .build();
    }

}
