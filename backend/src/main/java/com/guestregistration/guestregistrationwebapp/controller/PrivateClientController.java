package com.guestregistration.guestregistrationwebapp.controller;

import com.guestregistration.guestregistrationwebapp.dto.PrivateClientDTO;
import com.guestregistration.guestregistrationwebapp.service.PrivateClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Slf4j
@RequestMapping("private-clients")
@CrossOrigin
public class PrivateClientController {

    private final PrivateClientService privateClientService;

    public PrivateClientController(PrivateClientService privateClientService) {
        this.privateClientService = privateClientService;
    }

    @PostMapping
    public PrivateClientDTO createNewPrivateClient(@RequestBody PrivateClientDTO toStore) {
        log.info("Trying to store new private client: [{}]", toStore);
        return privateClientService.createNewPrivateClient(toStore);
    }

    @GetMapping("/read-all-private-clients")
    public List<PrivateClientDTO> readAllPrivateClients() {
        log.info("Reading all private clients...");
        return privateClientService.findAllPrivateClients();
    }
}
