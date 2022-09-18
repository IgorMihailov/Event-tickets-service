package com.events.service.controller;

import com.events.service.entity.Artist;
import com.events.service.service.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return artistService.create(artist);
    }

    @GetMapping("/{id}")
    public Artist findOne(@PathVariable Long id) {
        return artistService.findOne(id);
    }

    @GetMapping
    public List<Artist> findAll() {
        return artistService.findAll();
    }

    @PostMapping("/{id}")
    public Artist update(@PathVariable Long id, @RequestBody Artist artist) {
        return artistService.update(id, artist);
    }

    @DeleteMapping("/{id}")
    public Artist delete(@PathVariable Long id) {
        return artistService.delete(id);
    }
}
