package com.guestregistration.guestregistrationwebapp.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Event {

    @Id
    @SequenceGenerator(name = "event_sequence", sequenceName = "event_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "event_sequence")
    private Long id;

    @NotEmpty(message = "Event name cannot be empty!")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Positive(message = "Participants quantity number should more than zero!")
    private int participantsQuantity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_private_clients",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "private_client_id")
    )
    List<PrivateClient> eventPrivateClients = new ArrayList<>();

}