package uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.entity.SearchAnalytic;

@Repository
public interface SearchAnalyticsRepository extends CrudRepository<SearchAnalytic, Long> {
}
