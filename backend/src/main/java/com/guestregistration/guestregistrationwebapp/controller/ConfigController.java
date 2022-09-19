package com.guestregistration.guestregistrationwebapp.controller;

import com.guestregistration.guestregistrationwebapp.dto.InitialConfig;
import com.guestregistration.guestregistrationwebapp.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // provides us just a data in a json format, it will help us to provide InitialConfig to frontend as json
@Slf4j
@RequestMapping("/config")
@CrossOrigin("*")
public class ConfigController {

    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping()
    public InitialConfig provideInitialConfig() {
        log.info("Provide initial config method was called");
        return configService.getInitialConfig();
    }
}
