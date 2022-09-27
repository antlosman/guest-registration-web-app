package com.guestregistration.guestregistrationwebapp.entity;


import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private String name;

    private LocalDate date;

    private int participantsQuantity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_private_clients",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "private_client_id")
    )
    List<PrivateClient> eventPrivateClients = new ArrayList<>();

}