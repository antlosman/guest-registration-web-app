package com.guestregistration.guestregistrationwebapp.controller;

import com.guestregistration.guestregistrationwebapp.converter.EventConverter;
import com.guestregistration.guestregistrationwebapp.dto.EventDTO;
import com.guestregistration.guestregistrationwebapp.dto.PrivateClientDTO;
import com.guestregistration.guestregistrationwebapp.entity.Event;
import com.guestregistration.guestregistrationwebapp.service.EventService;
import com.guestregistration.guestregistrationwebapp.service.PrivateClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/events")
@CrossOrigin
public class EventController {

    private final EventService eventService;

    private final EventConverter eventConverter;

    private final PrivateClientService privateClientService;

    public EventController(EventService eventService, EventConverter eventConverter, PrivateClientService privateClientService) {
        this.eventService = eventService;
        this.eventConverter = eventConverter;
        this.privateClientService = privateClientService;
    }

    // TODO: change method name to createNewEvent
    @PostMapping
    public EventDTO createNewPost(@RequestBody @Valid EventDTO toStore) {
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

    @PutMapping("/{eventID}/business-clients/{businessClientID}")
    public EventDTO assignBusinessClientToEvent(
            @PathVariable Long eventID,
            @PathVariable Long businessClientID
    ) {
        log.info("Trying to add business client to event...");
        Event event = eventService.addBusinessClientToEvent(eventID, businessClientID);
        return eventConverter.fromEntityToDto(event);
    }

    @GetMapping("/findEventById/{eventID}")
    public Optional<Event> findEventById(
            @PathVariable Long eventID
    ) {
        log.info("Trying to find event by id...");
        return eventService.getEvent(eventID);
    }

    // TODO: 11.10.2022 : delete this method from event controller?
    @PostMapping("/private-client")
    public PrivateClientDTO createNewPrivateClient(@RequestBody PrivateClientDTO toStore) {
        log.info("Trying to store new private client: [{}]", toStore);
        return privateClientService.createNewPrivateClient(toStore);
    }

    @DeleteMapping("/delete-event/{id}")
    public ResponseEntity<Event> deletePrivateClient(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
