package com.guestregistration.guestregistrationwebapp.service;

import com.guestregistration.guestregistrationwebapp.converter.EventConverter;
import com.guestregistration.guestregistrationwebapp.dto.EventDTO;
import com.guestregistration.guestregistrationwebapp.entity.Event;
import com.guestregistration.guestregistrationwebapp.repository.EventRepository;
import com.guestregistration.guestregistrationwebapp.repository.PrivateClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final EventConverter eventConverter;

    private final PrivateClientRepository privateClientRepository;


    public EventService(EventRepository eventRepository, EventConverter eventConverter, PrivateClientRepository clientRepository) {
        this.eventRepository = eventRepository;
        this.eventConverter = eventConverter;
        this.privateClientRepository = clientRepository;
    }

    public EventDTO createNewEvent(EventDTO toStore) {

        log.info("Creating new Event... [{}]", toStore);

        var entity = eventConverter.fromDtoToEntity(toStore);
        eventRepository.save(entity);
        var result = eventConverter.fromEntityToDto(entity);

        log.info("New event successfully created: [{}]", result);

        return result;
    }

    public List<EventDTO> findAllEvents() {
        var result = eventRepository.findAll();
        log.debug("Result: [{}]", result);
        log.info("Number of read events: [{}]", result.size());
        return result
                .stream()
                .map(eventConverter::fromEntityToDto)
                .toList();
    }

    public List<EventDTO> findAllEventsBeforeToday() {
        var result = eventRepository.findAllByDateBefore(LocalDate.now());
        log.debug("Result: [{}]", result);
        log.info("Number of read events: [{}]", result.size());
        return result
                .stream()
                .map(eventConverter::fromEntityToDto)
                .toList();
    }

    public List<EventDTO> findAllEventsAfterToday() {
        var result = eventRepository.findAllByDateAfter(LocalDate.now());
        log.debug("Result: [{}]", result);
        log.info("Number of read events: [{}]", result.size());
        return result
                .stream()
                .map(eventConverter::fromEntityToDto)
                .toList();
    }

    public Event addPrivateClientToEvent(Long eventId, Long privateClientId) {
        log.debug("Adding new private client to event...");
        var event = eventRepository.findById(eventId).get();
        var privateClient = privateClientRepository.findById(privateClientId).get();
        event.getEventPrivateClients().add(privateClient);
        log.info("New private client successfully added to event: [{}]", event);
        return eventRepository.save(event);
    }

    public EventDTO getEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id.toString()));
        return eventConverter.fromEntityToDto(event);
    }

}
