package com.guestregistration.guestregistrationwebapp.repository;

import com.guestregistration.guestregistrationwebapp.entity.BusinessClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessClientRepository extends JpaRepository<BusinessClient, Long> {

}
