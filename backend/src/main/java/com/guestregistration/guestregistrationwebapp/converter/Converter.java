package com.guestregistration.guestregistrationwebapp.converter;

public interface Converter<DTO, ENTITY> {
    ENTITY fromDtoToEntity(DTO dto);
    DTO fromEntityToDto(ENTITY entity);
}
