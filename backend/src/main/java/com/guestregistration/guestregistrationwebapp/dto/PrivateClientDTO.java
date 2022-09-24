package com.guestregistration.guestregistrationwebapp.dto;

public record PrivateClientDTO(
        Long id,
        String firstName,
        String lastName,
        Long idNumber,
        String paymentMethod,
        String additionalInfo
) {

}
