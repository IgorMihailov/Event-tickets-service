package com.events.service.service;

import com.events.service.dao.CityRepository;
import com.events.service.entity.City;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public City findOne(Long id) {
        Optional<City> city = cityRepository.findById(id);
        city.orElseThrow(() -> new EntityNotFoundException("City not found"));
        return city.get();
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City update(Long id, City city) {
        City oldCity = findOne(id);
        oldCity.setName(city.getName());
        return cityRepository.save(oldCity);
    }

    public City delete(Long id) {
        City city = findOne(id);
        city.setDeleted(true);
        cityRepository.save(city);
        return city;
    }
}
