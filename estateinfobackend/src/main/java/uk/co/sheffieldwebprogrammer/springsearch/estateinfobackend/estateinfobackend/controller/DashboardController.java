package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.model.DashboardDto;
import uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.service.PropertyService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<DashboardDto> getDashboard() {
        DashboardDto dashboardDto = new DashboardDto();
        dashboardDto.setNoProperties(propertyService.countProperties());
        return ResponseEntity.ok(dashboardDto);
    }


}
