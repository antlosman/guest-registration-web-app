package com.guestregistration.guestregistrationwebapp.repository;

import com.guestregistration.guestregistrationwebapp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
