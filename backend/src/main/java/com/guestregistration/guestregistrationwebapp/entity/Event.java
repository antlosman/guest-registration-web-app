package com.guestregistration.guestregistrationwebapp.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Event {

    @Id
    @SequenceGenerator(name = "event_sequence", sequenceName = "event_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "event_sequence")
    private Long id;

    private String name;

    private LocalDate date;

    private int participantsQuantity;

}