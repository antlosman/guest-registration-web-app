package com.guestregistration.guestregistrationwebapp.service;

import com.guestregistration.guestregistrationwebapp.converter.EventConverter;
import com.guestregistration.guestregistrationwebapp.dto.EventDTO;
import com.guestregistration.guestregistrationwebapp.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final EventConverter eventConverter;

    public EventService(EventRepository eventRepository, EventConverter eventConverter) {
        this.eventRepository = eventRepository;
        this.eventConverter = eventConverter;
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
}
