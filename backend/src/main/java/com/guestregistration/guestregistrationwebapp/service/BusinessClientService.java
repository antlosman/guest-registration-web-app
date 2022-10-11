package com.guestregistration.guestregistrationwebapp.service;


import com.guestregistration.guestregistrationwebapp.converter.BusinessClientConverter;
import com.guestregistration.guestregistrationwebapp.dto.BusinessClientDTO;
import com.guestregistration.guestregistrationwebapp.entity.BusinessClient;
import com.guestregistration.guestregistrationwebapp.repository.BusinessClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BusinessClientService {

    private final BusinessClientRepository businessClientRepository;

    private final BusinessClientConverter businessClientConverter;

    public BusinessClientService(BusinessClientRepository businessClientRepository, BusinessClientConverter businessClientConverter) {
        this.businessClientRepository = businessClientRepository;
        this.businessClientConverter = businessClientConverter;
    }

    public BusinessClientDTO createNewBusinessClient(BusinessClientDTO businessClientDTO) {

        log.info("Creating new Business Client... [{}]", businessClientDTO);

        var businessClientEntity = businessClientConverter.fromDtoToEntity(businessClientDTO);
        var dbEntity = businessClientRepository.save(businessClientEntity);
        var result = businessClientConverter.fromEntityToDto(dbEntity);

        log.info("New Business Client successfully created: [{}]", result);

        return result;
    }

    public List<BusinessClientDTO> findAllBusinessClients() {
        var result = businessClientRepository.findAll();
        log.debug("Result: [{}]", result);
        log.info("Number of read business clients: [{}]", result.size());
        return result
                .stream()
                .map(businessClientConverter::fromEntityToDto)
                .toList();
    }

    public Optional<BusinessClient> getBusinessClientById(Long id) {
        log.debug("Trying to find business client by id...");
        return businessClientRepository.findById(id);
    }

    public BusinessClientDTO updateBusinessClient(BusinessClientDTO businessClientToUpdate) {
        log.debug("Trying to update business client...");
        var entity = businessClientConverter.fromDtoToEntity(businessClientToUpdate);
        businessClientRepository.save(entity);
        var result = businessClientConverter.fromEntityToDto(entity);
        log.info("Business client is updated: [{}]", result);
        return result;
    }

    public void deleteBusinessClient(Long id) {
        businessClientRepository.deleteById(id);
    }

}
