package com.spring.project.carparking.location;

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

import com.spring.project.carparking.location.CarparkingLocation;
import com.spring.project.carparking.location.CarparkingLocationNotFoundException;

import com.spring.project.carparking.location.CarparkingLocationRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/")
public class CarparkingLocationResource {

	@Autowired
	private CarparkingLocationRepository carparkinglocationRepository;
	@GetMapping("location")
	public List<CarparkingLocation> retrieveAllCarparkinglocation() {
		return carparkinglocationRepository.findAll();
	}

	@GetMapping("location/{location}")
	public CarparkingLocation retrieveCarparkingLocation(@PathVariable String location) {
		Optional<CarparkingLocation>carparkinglocation = carparkinglocationRepository.findById(location);

		if (!carparkinglocation.isPresent())
			throw new CarparkingLocationNotFoundException("location-" + location);

		return carparkinglocation.get();
	}
 
	@DeleteMapping("location/{location}")
	public void deleteCarparkingLocation(@PathVariable String location) {
		carparkinglocationRepository.deleteById(location);
	}

	@PostMapping("location")
	public ResponseEntity<Object> createcarparkinglocation(@RequestBody CarparkingLocation carparkinglocation) {
	
		   
		
		CarparkingLocation saveCarparkingLocation = carparkinglocationRepository.save(carparkinglocation);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{location}")
				.buildAndExpand(saveCarparkingLocation.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("location/{location}")
	public ResponseEntity<Object> updatecarparkinglocation(@RequestBody CarparkingLocation carparkinglocation, @PathVariable String location) {

		Optional<CarparkingLocation> carparkinglocationOptional = carparkinglocationRepository.findById(location);

		if (!carparkinglocationOptional.isPresent())
			return ResponseEntity.notFound().build();

		carparkinglocation.setLocation(location);
		
		carparkinglocationRepository.save(carparkinglocation);

		return ResponseEntity.noContent().build();
	}
}

	

