package com.guestregistration.guestregistrationwebapp.controller;

import com.guestregistration.guestregistrationwebapp.converter.EventConverter;
import com.guestregistration.guestregistrationwebapp.dto.EventDTO;
import com.guestregistration.guestregistrationwebapp.entity.Event;
import com.guestregistration.guestregistrationwebapp.repository.EventRepository;
import com.guestregistration.guestregistrationwebapp.repository.PrivateClientRepository;
import com.guestregistration.guestregistrationwebapp.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@Slf4j
@RequestMapping("/events")
@CrossOrigin("${allowed.origin.url}")
public class EventController {

    private final EventService eventService;

    private final EventConverter eventConverter;

    public EventController(EventService eventService, EventConverter eventConverter) {
        this.eventService = eventService;
        this.eventConverter = eventConverter;
    }

    // TODO: change method name to createNewEvent
    @PostMapping
    public EventDTO createNewPost(@RequestBody EventDTO toStore) {
        log.info("Trying to store new post: [{}]", toStore);
        return eventService.createNewEvent(toStore);
    }

    @GetMapping("/read-all-events")
    public List<EventDTO> readAllEvents() {
        log.info("Reading all events...");
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

    @PutMapping("/{eventID}/private-clients/{privateClientID}")
    public EventDTO assignPrivateClientToEvent(
            @PathVariable Long eventID,
            @PathVariable Long privateClientID
            //@RequestBody EventDTO eventDTO
    ) {
        log.info("Trying to add private client to event...");

        Event event = eventService.addPrivateClientToEvent(eventID, privateClientID);
        return eventConverter.fromEntityToDto(event);
    }


    @GetMapping("/findEventById/{eventID}")
    public ResponseEntity<EventDTO> findEventById(
            @PathVariable Long eventID
    ) {
        log.info("Trying to find event by id...");
        return status(HttpStatus.OK).body(eventService.getEvent(eventID));
    }
}
