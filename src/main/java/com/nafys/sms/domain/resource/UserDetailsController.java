package com.nafys.sms.domain.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nafys.sms.domain.UserDetails;
import com.nafys.sms.dto.LoginDTO;
import com.nafys.sms.repository.UserDetailsRepository;



@RestController
@RequestMapping("/api")
public class UserDetailsController {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@PostMapping("/user-detailss")
	public ResponseEntity<UserDetails> registerUser(@RequestBody UserDetails userDetails) {
		System.out.println(userDetails);
		UserDetails entity = userDetailsRepository.save(userDetails);
		// return new ResponseEntity<Student>(entity, HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entity);
	}

	@GetMapping("/user-detailss")
	@CrossOrigin
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		List<UserDetails> userDetailss = userDetailsRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(userDetailss);
	}

	@GetMapping("/user-detailss/{id}")
	public ResponseEntity<UserDetails> getUser(@PathVariable Long id) {
		Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userDetails.get());
	}
	
	@PostMapping("/user-detailss/login")
	public ResponseEntity<UserDetails> getLogin(@RequestBody LoginDTO loginDto) {
		Optional<UserDetails> userDetails = userDetailsRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userDetails.get());
	}
}
