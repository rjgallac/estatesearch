package uk.co.sheffieldwebprogrammer.estatesearch.analyticsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @GetMapping
    public void getAnalytics(){}

}
