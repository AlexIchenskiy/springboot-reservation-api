package com.agency04.devcademy.repository;

import com.agency04.devcademy.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    List<Accommodation> findByCategorizationAndPersonCountGreaterThanEqual(Integer stars, Integer beds);

}
