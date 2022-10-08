package com.guestregistration.guestregistrationwebapp.controller;

import com.guestregistration.guestregistrationwebapp.dto.PrivateClientDTO;
import com.guestregistration.guestregistrationwebapp.entity.PrivateClient;
import com.guestregistration.guestregistrationwebapp.repository.PrivateClientRepository;
import com.guestregistration.guestregistrationwebapp.service.PrivateClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("private-clients")
@CrossOrigin
public class PrivateClientController {

    private final PrivateClientService privateClientService;
    private final PrivateClientRepository privateClientRepository;

    public PrivateClientController(PrivateClientService privateClientService, PrivateClientRepository privateClientRepository) {
        this.privateClientService = privateClientService;
        this.privateClientRepository = privateClientRepository;
    }

    @PostMapping
    public PrivateClientDTO createNewPrivateClient(@RequestBody @Valid PrivateClientDTO toStore) {
        log.info("Trying to store new private client: [{}]", toStore);
        return privateClientService.createNewPrivateClient(toStore);
    }

    @GetMapping("/read-all-private-clients")
    public List<PrivateClientDTO> readAllPrivateClients() {
        log.info("Reading all private clients...");
        return privateClientService.findAllPrivateClients();
    }

    @PutMapping("/update-private-client")
    public PrivateClientDTO editPrivateClient(@RequestBody PrivateClientDTO toStore) {
        log.info("Trying to update private client...");
        return privateClientService.updatePrivateClient(toStore);
    }

    @GetMapping("/find-private-client-by-id/{privateClientId}")
    public Optional<PrivateClient> findPrivateClientById(@PathVariable Long privateClientId) {
        log.info("Trying to find event by id...");
        return privateClientService.getPrivateClientById(privateClientId);
    }

    //todo: do logic in service
    @PutMapping("/update-private-client-by-id/{id}")
    public ResponseEntity<PrivateClient> updatePrivateClientById(
            @PathVariable Long id,
            @RequestBody PrivateClient privateClientToUpdate){
        PrivateClient privateClient = privateClientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not exist with id :" + id));

        privateClient.setFirstName(privateClientToUpdate.getFirstName());
        privateClient.setLastName(privateClientToUpdate.getLastName());
        privateClient.setIdNumber(privateClientToUpdate.getIdNumber());
        privateClient.setPaymentMethod(privateClientToUpdate.getPaymentMethod());
        privateClient.setAdditionalInfo(privateClientToUpdate.getAdditionalInfo());

        PrivateClient updatedPrivateClient = privateClientRepository.save(privateClient);
        return ResponseEntity.ok(updatedPrivateClient);
    }

    @DeleteMapping("/delete-private-client/{id}")
    public ResponseEntity<PrivateClient> deletePrivateClient(@PathVariable Long id) {
        privateClientService.deletePrivateClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
