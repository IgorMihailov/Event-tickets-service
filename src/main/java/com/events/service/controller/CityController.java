package com.events.service.controller;

import com.events.service.entity.City;
import com.events.service.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public City create(@RequestBody City city) {
        return cityService.create(city);
    }

    @GetMapping("/{id}")
    public City findOne(@PathVariable Long id) {
        return cityService.findOne(id);
    }

    @GetMapping
    public List<City> findAll() {
        return cityService.findAll();
    }

    @PostMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City city) {
        return cityService.update(id, city);
    }

    @DeleteMapping("/{id}")
    public City delete(@PathVariable Long id) {
        return cityService.delete(id);
    }
}
