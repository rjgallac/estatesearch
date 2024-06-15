package uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.entity.Analytic;
import uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.entity.SearchAnalytic;
import uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.model.SearchRequest;
import uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.model.ViewRequest;
import uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.repository.AnalyticsRepository;
import uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.repository.SearchAnalyticsRepository;

@RestController
@RequestMapping("/analyticsservice/analytics")
public class AnalyticsController {

    @Autowired
    private SearchAnalyticsRepository searchAnalyticsRepository;

    @Autowired
    private AnalyticsRepository analyticsRepository;

    @GetMapping
    public void getAnalytics(){}

    @PostMapping("/search")
    public void postSearch(@RequestBody SearchRequest searchRequest) {
        SearchAnalytic searchAnalytic = new SearchAnalytic();
        searchAnalytic.setBeds(searchRequest.getBeds());
        searchAnalytic.setTerms(searchRequest.getTerms());
        searchAnalytic.setMaxPrice(searchRequest.getMaxPrice());
    }

    @PostMapping("/view")
    public void postView(@RequestBody ViewRequest viewRequest){
        Analytic analytic = new Analytic();
        analytic.setPropertyId(viewRequest.getPropertyId());
        analyticsRepository.save(analytic);
    }

    @GetMapping("/total")
    public long total(){
        return analyticsRepository.count();
    }
}
