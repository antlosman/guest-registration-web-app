package com.guestregistration.guestregistrationwebapp.controller;

import com.guestregistration.guestregistrationwebapp.dto.EventDTO;
import com.guestregistration.guestregistrationwebapp.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/events")
@CrossOrigin("${allowed.origin.url}")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public EventDTO createNewPost(@RequestBody EventDTO toStore) {
        log.info("Trying to store new post: [{}]", toStore);
        return eventService.createNewEvent(toStore);
    }

    @GetMapping("/read-all-events")
    public List<EventDTO> readAllEvents() {
        log.info("Reading recent events...");
        return eventService.findAllEvents();
    }

    @GetMapping("read-all-events-before-today")
    public List<EventDTO> readAllEventsBeforeToday() {
        log.info("Reading events before today...");
        return eventService.findAllEventsBeforeToday();
    }

    @GetMapping("read-all-events-after-today")
    public List<EventDTO> readAllEventsAfterToday() {
        log.info("Reading events after today...");
        return eventService.findAllEventsAfterToday();
    }
}
