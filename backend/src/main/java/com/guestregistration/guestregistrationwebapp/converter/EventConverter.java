package com.guestregistration.guestregistrationwebapp.converter;

import com.guestregistration.guestregistrationwebapp.dto.EventDTO;
import com.guestregistration.guestregistrationwebapp.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class EventConverter implements Converter<EventDTO, Event> {

    @Override
    public Event fromDtoToEntity(EventDTO eventDTO) {
        return Event.builder()
                .id(eventDTO.id())
                .name(eventDTO.name())
                .date(eventDTO.date())
                .participantsQuantity(eventDTO.participantsQuantity())
                .build();
    }

    @Override
    public EventDTO fromEntityToDto(Event event) {
        return new EventDTO(
                event.getId(),
                event.getName(),
                event.getDate(),
                event.getParticipantsQuantity()
        );
    }
}
