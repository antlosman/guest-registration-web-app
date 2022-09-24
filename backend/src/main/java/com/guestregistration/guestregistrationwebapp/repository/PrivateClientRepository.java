package com.guestregistration.guestregistrationwebapp.repository;

import com.guestregistration.guestregistrationwebapp.entity.PrivateClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivateClientRepository extends JpaRepository<PrivateClient, Long> {
}
