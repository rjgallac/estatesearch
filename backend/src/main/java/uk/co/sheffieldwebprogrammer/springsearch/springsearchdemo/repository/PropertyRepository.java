package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model.Property;

import java.util.List;

@Repository
public interface PropertyRepository extends ElasticsearchRepository<Property, String> {

    Page<Property> findByDescriptionContaining(String description, Pageable pageable);

    List<Property> findByDescriptionContaining(String name);

    @Query("{\"match\": {\"price\": {\"query\": \"?0\"}}}")
    Page<Property> findByPrice(Long price, Pageable pageable);

}