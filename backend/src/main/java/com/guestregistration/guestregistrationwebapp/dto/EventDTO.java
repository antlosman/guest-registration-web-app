package com.guestregistration.guestregistrationwebapp.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public record EventDTO(
        Long id,
        @NotEmpty(message = "Event name cannot be empty!")
        String name,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate date,
        @Positive(message = "Participants quantity number should more than zero!")
        int participantsQuantity
) {
}
