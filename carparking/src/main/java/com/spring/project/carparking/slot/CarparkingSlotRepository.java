package com.spring.project.carparking.slot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface CarparkingSlotRepository extends JpaRepository<CarparkingSlot ,Long>{
	 


}
