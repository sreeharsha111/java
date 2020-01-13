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
import com.spring.project.carparking.user.User;

import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@RequestMapping(path = "/")
public class CarparkingSlotResource {

	@Autowired
	private CarparkingSlotRepository carparkingslotRepository;
	@GetMapping("/api/slot")
	@ApiOperation(value="finds the slot ",
	notes="displays the values",
	response=CarparkingSlot.class)
	public List<CarparkingSlot> retrieveAllCarparkingSlot() {
		return carparkingslotRepository.findAll();
	}

	@GetMapping("/api/slot/{id}")
	@ApiOperation(value="finds specific slot ",
	notes="displays the specific values",
	response=CarparkingSlot.class)
	public CarparkingSlot retrieveCarparkingSlot(@PathVariable long id) {
		Optional<CarparkingSlot>carparkingslot = carparkingslotRepository.findById(id);

		if (!carparkingslot.isPresent())
			throw new CarparkingSlotNotFoundException("id-" + id);

		return carparkingslot.get();
	}
 
	@DeleteMapping("/api/slot/{id}")
	@ApiOperation(value="deletes specific slot ",
	notes="deletes the specific values",
	response=CarparkingSlot.class)
	public void deleteCarparkingSlot(@PathVariable long id) {
		carparkingslotRepository.deleteById(id);
	}

	@PostMapping("/api/slot")
	@ApiOperation(value="gives slot ",
	notes="gives the values",
	response=CarparkingSlot.class)
	public ResponseEntity<Object> createcarparkingslot(@RequestBody CarparkingSlot carparkingslot) {
	
		   
		
		CarparkingSlot saveCarparkingSlot = carparkingslotRepository.save(carparkingslot);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveCarparkingSlot.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/api/slot/{id}")
	@ApiOperation(value="modifies specific slot ",
	notes="modifies the specific values",
	response=CarparkingSlot.class)
	public ResponseEntity<Object> updatecarparkingslot(@RequestBody CarparkingSlot carparkingslot, @PathVariable long id) {

		Optional<CarparkingSlot> carparkingslotOptional = carparkingslotRepository.findById(id);

		if (!carparkingslotOptional.isPresent())
			return ResponseEntity.notFound().build();

		carparkingslot.setId(id);
		
		carparkingslotRepository.save(carparkingslot);

		return ResponseEntity.noContent().build();
	}
}

