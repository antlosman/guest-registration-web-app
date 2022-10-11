package com.guestregistration.guestregistrationwebapp.converter;

import com.guestregistration.guestregistrationwebapp.dto.BusinessClientDTO;
import com.guestregistration.guestregistrationwebapp.entity.BusinessClient;
import org.springframework.stereotype.Component;

@Component
public class BusinessClientConverter implements Converter<BusinessClientDTO, BusinessClient> {


    @Override
    public BusinessClient fromDtoToEntity(BusinessClientDTO businessClientDTO) {
        return BusinessClient.builder()
                .id(businessClientDTO.id())
                .companyName(businessClientDTO.companyName())
                .registerCode(businessClientDTO.registerCode())
                .participantsQuantity(businessClientDTO.participantsQuantity())
                .paymentMethod(businessClientDTO.paymentMethod())
                .additionalInfo(businessClientDTO.additionalInfo())
                .build();
    }

    @Override
    public BusinessClientDTO fromEntityToDto(BusinessClient businessClient) {
        return new BusinessClientDTO(
                businessClient.getId(),
                businessClient.getCompanyName(),
                businessClient.getRegisterCode(),
                businessClient.getParticipantsQuantity(),
                businessClient.getPaymentMethod(),
                businessClient.getAdditionalInfo()
        );
    }
}
