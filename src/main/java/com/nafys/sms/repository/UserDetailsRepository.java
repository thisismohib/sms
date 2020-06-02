package com.nafys.sms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nafys.sms.domain.UserDetails;

//@CrossOrigin("http://localhost:4200")
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
	
	Optional<UserDetails> findByEmailAndPassword(String email, String password);

}
