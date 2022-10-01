package com.guestregistration.guestregistrationwebapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PrivateClient {

    @Id
    @SequenceGenerator(name = "client_sequence", sequenceName = "client_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "client_sequence")
    private Long id;

    private String firstName;

    private String lastName;

    private Long idNumber;

    private String paymentMethod;

    private String additionalInfo;

    @JsonIgnore
    @ManyToMany(mappedBy = "eventPrivateClients", cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
}
