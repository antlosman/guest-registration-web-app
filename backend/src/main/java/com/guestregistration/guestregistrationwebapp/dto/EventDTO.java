package com.guestregistration.guestregistrationwebapp.dto;


public record EventDTO(
        Long id,
        String name,
        String date,
        int participantsQuantity
) {
}
