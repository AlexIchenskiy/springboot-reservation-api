package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
