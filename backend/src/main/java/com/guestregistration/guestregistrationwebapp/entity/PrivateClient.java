package com.guestregistration.guestregistrationwebapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guestregistration.guestregistrationwebapp.enumeration.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

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

    @NotEmpty(message = "First name cannot by empty!")
    private String firstName;

    @NotEmpty(message = "Last name cannot by empty!")
    private String lastName;

    @Digits(integer = 11, fraction = 0)
    private Long idNumber;

    private PaymentMethod paymentMethod;

    private String additionalInfo;

    @JsonIgnore
    @ManyToMany(mappedBy = "eventPrivateClients", cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
}
