package com.spring.project.carparking.slot;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.project.carparking.slot.CarparkingSlot;
import com.spring.project.carparking.slot.CarparkingSlotNotFoundException;


@CrossOrigin
@RestController
@RequestMapping(path = "/")
public class CarparkingSlotResource {

	@Autowired
	private CarparkingSlotRepository carparkingslotRepository;
	@GetMapping("slot")
	public List<CarparkingSlot> retrieveAllCarparkingSlot() {
		return carparkingslotRepository.findAll();
	}

	@GetMapping("slot/{id}")
	public CarparkingSlot retrieveCarparkingSlot(@PathVariable long id) {
		Optional<CarparkingSlot>carparkingslot = carparkingslotRepository.findById(id);

		if (!carparkingslot.isPresent())
			throw new CarparkingSlotNotFoundException("id-" + id);

		return carparkingslot.get();
	}
 
	@DeleteMapping("slot/{id}")
	public void deleteCarparkingSlot(@PathVariable long id) {
		carparkingslotRepository.deleteById(id);
	}

	@PostMapping("slot")
	public ResponseEntity<Object> createcarparkingslot(@RequestBody CarparkingSlot carparkingslot) {
	
		   
		
		CarparkingSlot saveCarparkingSlot = carparkingslotRepository.save(carparkingslot);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveCarparkingSlot.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("slot/{id}")
	public ResponseEntity<Object> updatecarparkingslot(@RequestBody CarparkingSlot carparkingslot, @PathVariable long id) {

		Optional<CarparkingSlot> carparkingslotOptional = carparkingslotRepository.findById(id);

		if (!carparkingslotOptional.isPresent())
			return ResponseEntity.notFound().build();

		carparkingslot.setId(id);
		
		carparkingslotRepository.save(carparkingslot);

		return ResponseEntity.noContent().build();
	}
}

