package com.guestregistration.guestregistrationwebapp.repository;

import com.guestregistration.guestregistrationwebapp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    public List<Event> findAllByDateBefore(LocalDate todayDate);

    public List<Event> findAllByDateAfter(LocalDate todayDate);

}
