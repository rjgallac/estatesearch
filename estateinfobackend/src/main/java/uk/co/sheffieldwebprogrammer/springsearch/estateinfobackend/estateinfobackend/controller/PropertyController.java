package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propertyinfo")
public class PropertyController {

    @GetMapping("/{id}")
    @CrossOrigin
    public String getById(@PathVariable("id") String id) {
        return "{}";
    }


}
