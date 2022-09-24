package com.guestregistration.guestregistrationwebapp.converter;

import com.guestregistration.guestregistrationwebapp.dto.PrivateClientDTO;
import com.guestregistration.guestregistrationwebapp.entity.PrivateClient;
import org.springframework.stereotype.Component;

@Component
public class PrivateClientConverter implements Converter<PrivateClientDTO, PrivateClient> {

    @Override
    public PrivateClient fromDtoToEntity(PrivateClientDTO privateClientDTO) {
        return PrivateClient.builder()
                .id(privateClientDTO.id())
                .firstName(privateClientDTO.firstName())
                .lastName(privateClientDTO.lastName())
                .idNumber(privateClientDTO.idNumber())
                .paymentMethod(privateClientDTO.paymentMethod())
                .additionalInfo(privateClientDTO.additionalInfo())
                .build();
    }

    @Override
    public PrivateClientDTO fromEntityToDto(PrivateClient privateClient) {
        return new PrivateClientDTO(
                privateClient.getId(),
                privateClient.getFirstName(),
                privateClient.getLastName(),
                privateClient.getIdNumber(),
                privateClient.getPaymentMethod(),
                privateClient.getAdditionalInfo()
        );
    }
}
