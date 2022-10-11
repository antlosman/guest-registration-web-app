package com.guestregistration.guestregistrationwebapp.entity;


import com.guestregistration.guestregistrationwebapp.enumeration.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "BusinessClient")
public class BusinessClient {

    @Id
    @SequenceGenerator(
            name = "business_client_sequence",
            sequenceName = "business_client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "business_client_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "company_name", nullable = false, columnDefinition = "TEXT")
    @NotEmpty(message = "Company name cannot by empty!")
    private String companyName;

    @Column(name = "register_code", nullable = false)
    @Positive(message = "Company register code should be greater than zero!")
    private Long registerCode;

    @Column(name = "participants_quantity")
    @Min(value = 1, message = "Minimum quantity equals 1")
    private int participantsQuantity;

    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "additional_info", columnDefinition = "TEXT")
    @Size(max = 5000)
    private String additionalInfo;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Event events;
}
