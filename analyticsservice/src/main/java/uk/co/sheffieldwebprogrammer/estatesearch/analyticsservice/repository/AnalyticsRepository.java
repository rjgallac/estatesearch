package uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.repository;

import org.springframework.data.repository.CrudRepository;
import uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.entity.Analytic;

public interface AnalyticsRepository extends CrudRepository <Analytic, Long> {
    long count();
}
