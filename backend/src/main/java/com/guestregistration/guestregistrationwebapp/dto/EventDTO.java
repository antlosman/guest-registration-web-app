package com.guestregistration.guestregistrationwebapp.dto;


import java.time.LocalDate;

public record EventDTO(
        Long id,
        String name,
        LocalDate date,
        int participantsQuantity
) {
}
