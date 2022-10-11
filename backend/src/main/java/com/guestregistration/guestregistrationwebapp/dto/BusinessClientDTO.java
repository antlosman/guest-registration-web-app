package com.guestregistration.guestregistrationwebapp.dto;

import com.guestregistration.guestregistrationwebapp.enumeration.PaymentMethod;

import javax.validation.constraints.*;

public record BusinessClientDTO(

        Long id,

        @NotEmpty(message = "Company name cannot by empty!")
        String companyName,

        @Positive(message = "Company register code should be greater than zero!")
        Long registerCode,

        @Min(value = 1, message = "Minimum quantity equals 1")
        int participantsQuantity,

        PaymentMethod paymentMethod,

        @Size(max = 5000)
        String additionalInfo
) {


}
