package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.entity.Property;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.repository.PropertyRepository;

import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;


    public Optional<Property> findById(long id) {
        return propertyRepository.findById(id);
    }
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    public Page<Property> findByPage(Pageable pageable) {
        return propertyRepository.findAll(pageable);
    }

    public long countProperties() {
        return propertyRepository.count();
    }

    public void delete(long id) {
        propertyRepository.deleteById(id);
    }
}
