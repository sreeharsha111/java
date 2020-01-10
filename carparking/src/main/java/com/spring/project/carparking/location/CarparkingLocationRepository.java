package com.spring.project.carparking.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarparkingLocationRepository extends JpaRepository<CarparkingLocation ,String>{



}