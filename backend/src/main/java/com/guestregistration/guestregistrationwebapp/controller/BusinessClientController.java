package com.guestregistration.guestregistrationwebapp.controller;

import com.guestregistration.guestregistrationwebapp.dto.BusinessClientDTO;
import com.guestregistration.guestregistrationwebapp.entity.BusinessClient;
import com.guestregistration.guestregistrationwebapp.repository.BusinessClientRepository;
import com.guestregistration.guestregistrationwebapp.service.BusinessClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("business-clients")
@CrossOrigin
public class BusinessClientController {

    private final BusinessClientService businessClientService;
    private final BusinessClientRepository businessClientRepository;

    public BusinessClientController(BusinessClientService businessClientService, BusinessClientRepository businessClientRepository) {
        this.businessClientService = businessClientService;
        this.businessClientRepository = businessClientRepository;
    }

    @PostMapping
    public BusinessClientDTO addNewBusinessClient(@RequestBody @Valid BusinessClientDTO businessClientDTO) {
        log.info("Trying to store new Business Client: [{}]", businessClientDTO);
        return businessClientService.createNewBusinessClient(businessClientDTO);
    }

    @GetMapping("/read-all-business-clients")
    public List<BusinessClientDTO> readAllBusinessClients() {
        log.info("Reading all business clients...");
        return businessClientService.findAllBusinessClients();
    }

    @GetMapping("/find-business-client-by-id/{id}")
    public Optional<BusinessClient> findBusinessClientById(@PathVariable Long id) {
        log.info("Trying to find business client by id...");
        return businessClientService.getBusinessClientById(id);
    }

    @PutMapping("/update-business-client-by-id/{id}")
    public ResponseEntity<BusinessClient> updateBusinessClientById(
            @PathVariable Long id,
            @RequestBody BusinessClient businessClientToUpdate){
        BusinessClient businessClient = businessClientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business client not exist with id :" + id));

        businessClient.setCompanyName(businessClientToUpdate.getCompanyName());
        businessClient.setRegisterCode(businessClientToUpdate.getRegisterCode());
        businessClient.setParticipantsQuantity(businessClientToUpdate.getParticipantsQuantity());
        businessClient.setPaymentMethod(businessClientToUpdate.getPaymentMethod());
        businessClient.setAdditionalInfo(businessClientToUpdate.getAdditionalInfo());

        BusinessClient updatedBusinessClient = businessClientRepository.save(businessClient);
        return ResponseEntity.ok(updatedBusinessClient);
    }

    @DeleteMapping("/delete-business-client/{id}")
    public ResponseEntity<BusinessClient> deleteBusinessClient(@PathVariable Long id) {
        businessClientService.deleteBusinessClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
