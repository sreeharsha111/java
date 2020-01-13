package com.spring.project.carparking.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(path = "/")
@Api(value="carparking",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/api/users")
	@ApiOperation(value="finds users ",
	notes="displays the values",
	response=User.class)
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/api/users/{id}")
	@ApiOperation(value="finds usersy by id",
	notes="displays the values of specific id",
	response=User.class)
	public User retrieveUser(@PathVariable long id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);

		return user.get();
	}
	@DeleteMapping("/api/users/{id}")
	@ApiOperation(value="deletes the users ",
	notes="deletes  the specific values",
	response=User.class)
	public void deleteUser(@PathVariable long id) {
		userRepository.deleteById(id);
	}

	@PostMapping("/api/users")
	@ApiOperation(value="gives users ",
	notes="inputs the values",
	response=User.class)
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("users/{id}")
	@ApiOperation(value="modifies users ",
	notes="modifies the specific values",
	response=User.class)
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {

		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		
		userRepository.save(user);

		return ResponseEntity.noContent().build();
	}
}