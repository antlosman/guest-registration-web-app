package com.guestregistration.guestregistrationwebapp.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public record EventDTO(
        Long id,
        @NotEmpty
        @Size(min = 3, message = "Minimum length of Event name is 3 characters! ")
        String name,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate date,
        int participantsQuantity
) {
}
