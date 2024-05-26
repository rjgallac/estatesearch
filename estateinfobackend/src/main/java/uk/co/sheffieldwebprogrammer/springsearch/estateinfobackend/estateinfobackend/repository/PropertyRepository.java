package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.entity.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {

    Page<Property> findAll(Pageable pageable);

    long count();
}
