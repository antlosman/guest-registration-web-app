package com.guestregistration.guestregistrationwebapp.service;

import com.guestregistration.guestregistrationwebapp.converter.EventConverter;
import com.guestregistration.guestregistrationwebapp.repository.EventRepository;
import com.guestregistration.guestregistrationwebapp.repository.PrivateClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventRepository eventRepository;
    @Mock
    private EventConverter eventConverter;
    @Mock
    private PrivateClientRepository privateClientRepository;

    private EventService underTest;

//    @BeforeEach
//    void setUp() {
//        underTest = new EventService(eventRepository, eventConverter, privateClientRepository );
//    }

    @Test
    void canGetAllEvents() {
        underTest.findAllEvents();
        verify(eventRepository).findAll();
    }


}