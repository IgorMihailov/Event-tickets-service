package com.events.service.controller;

import com.events.service.entity.Event;
import com.events.service.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.create(event);
    }

    @GetMapping("/{id}")
    public Event findOne(@PathVariable Long id) {
        return eventService.findOne(id);
    }

    @GetMapping
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @PostMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        return eventService.update(id, event);
    }

    @DeleteMapping("/{id}")
    public Event delete(@PathVariable Long id) {
        return eventService.delete(id);
    }
}
