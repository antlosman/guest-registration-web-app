package com.guestregistration.guestregistrationwebapp.service;

import com.guestregistration.guestregistrationwebapp.converter.PrivateClientConverter;
import com.guestregistration.guestregistrationwebapp.dto.PrivateClientDTO;
import com.guestregistration.guestregistrationwebapp.repository.PrivateClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PrivateClientService {

    private final PrivateClientRepository privateClientRepository;

    private final PrivateClientConverter privateClientConverter;

    public PrivateClientService(
            PrivateClientRepository privateClientRepository,
            PrivateClientConverter privateClientConverter) {

        this.privateClientRepository = privateClientRepository;
        this.privateClientConverter = privateClientConverter;
    }

    public PrivateClientDTO createNewPrivateClient(PrivateClientDTO toStore) {

        log.info("Creating new Private Client... [{}]", toStore);

        var entity = privateClientConverter.fromDtoToEntity(toStore);
        var dbEntity = privateClientRepository.save(entity);
        var result = privateClientConverter.fromEntityToDto(dbEntity);

        log.info("New Private Client successfully created: [{}]", result);

        return result;
    }

    public List<PrivateClientDTO> findAllPrivateClients() {
        var result = privateClientRepository.findAll();
        log.debug("Result: [{}]", result);
        log.info("Number of read private clients: [{}]", result.size());
        return result
                .stream()
                .map(privateClientConverter::fromEntityToDto)
                .toList();
    }

    public PrivateClientDTO updatePrivateClient(PrivateClientDTO privateClientToUpdate) {
        log.debug("Trying to update private client...");
        var entity = privateClientConverter.fromDtoToEntity(privateClientToUpdate);
        privateClientRepository.save(entity);
        var result = privateClientConverter.fromEntityToDto(entity);
        log.info("Private client is updated: [{}]", result);
        return result;
    }

}
