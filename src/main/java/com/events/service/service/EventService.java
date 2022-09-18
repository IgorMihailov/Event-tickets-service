package com.events.service.service;

import com.events.service.dao.EventRepository;
import com.events.service.entity.Event;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public Event findOne(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        event.orElseThrow(() -> new EntityNotFoundException("Event not found"));
        return event.get();
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event update(Long id, Event event) {
        Event oldEvent = findOne(id);
        oldEvent.setName(event.getName());
        oldEvent.setAddress(event.getAddress());
        oldEvent.setArtist(event.getArtist());
        oldEvent.setCity(event.getCity());
        oldEvent.setPrice(event.getPrice());
        oldEvent.setDescription(event.getDescription());
        return eventRepository.save(oldEvent);
    }

    public Event delete(Long id) {
        Event event = findOne(id);
        event.setDeleted(true);
        eventRepository.save(event);
        return event;
    }
}
