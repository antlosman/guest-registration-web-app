package com.guestregistration.guestregistrationwebapp.service;

import com.guestregistration.guestregistrationwebapp.dto.InitialConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConfigService {

    private final String applicationName;

    public ConfigService(@Value("${guest.registration.web.app.name}") String applicationName) {
        log.info("application name: [{}]", applicationName);
        this.applicationName = applicationName;
    }

    public InitialConfig getInitialConfig() {
        return new InitialConfig(applicationName);
    }
}
