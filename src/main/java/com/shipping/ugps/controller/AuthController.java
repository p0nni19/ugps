package com.shipping.ugps.controller;

import jakarta.validation.Valid;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.ugps.models.User;
import com.shipping.ugps.repository.UserRepository;
import com.shipping.ugps.request.LoginRequest;
import com.shipping.ugps.request.SignupRequest;
import com.shipping.ugps.response.MessageResponse;
import com.shipping.ugps.response.UserInfoResponse;
import com.shipping.ugps.security.services.UserDetailsImpl;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	    try {
	        Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                loginRequest.getUsername(), loginRequest.getPassword())
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

	        return ResponseEntity.ok(
	            new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail()));
	    } catch (UsernameNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available");
	    } catch (BadCredentialsException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password is incorrect");
	    }
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (!signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
	        return ResponseEntity
	            .badRequest()
	            .body(new MessageResponse("Error: Password and Confirm Password do not match!"));
	    }
		
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}
		
		if (userRepository.existsByMobileNumber(signUpRequest.getMobileNumber())) {
		    return ResponseEntity.badRequest()
		        .body(new MessageResponse("Error: Mobile number is already in use!"));
		}

		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),signUpRequest.getMobileNumber());

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	/*
	 * @PostMapping("/signout") public ResponseEntity<?> logoutUser() {
	 * ResponseCookie cookie = jwtUtils.getCleanJwtCookie(); return
	 * ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	 * .body(new MessageResponse("You've been signed out!")); }
	 */
}
