package com.events.service.service;

import com.events.service.dao.ArtistRepository;
import com.events.service.entity.Artist;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist create(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist findOne(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        artist.orElseThrow(() -> new EntityNotFoundException("Artist not found"));
        return artist.get();
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Artist update(Long id, Artist artist) {
        Artist oldArtist = findOne(id);
        oldArtist.setName(artist.getName());
        return artistRepository.save(oldArtist);
    }

    public Artist delete(Long id) {
        Artist artist = findOne(id);
        artist.setDeleted(true);
        artistRepository.save(artist);
        return artist;
    }
}
