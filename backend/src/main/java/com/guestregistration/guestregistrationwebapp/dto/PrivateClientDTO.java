package com.guestregistration.guestregistrationwebapp.dto;

import javax.validation.constraints.*;


public record PrivateClientDTO(
        Long id,
        @NotEmpty(message = "First name cannot by empty!")
        String firstName,
        @NotEmpty(message = "Last name cannot by empty!")
        String lastName,
        //@Pattern(regexp = "^\\d{11}$")
        @Digits(integer = 11, fraction = 0)
        Long idNumber,
        String paymentMethod,
        String additionalInfo
) {

}
