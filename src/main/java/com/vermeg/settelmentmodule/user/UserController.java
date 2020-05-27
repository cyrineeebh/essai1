package com.vermeg.settelmentmodule.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")

public class UserController {
	@Autowired
	private UserRepository UserRepository;

	@GetMapping("/users")
	public List<com.vermeg.settelmentmodule.user> getAlluser() {
		return UserRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<com.vermeg.settelmentmodule.user> getuserById(
			@PathVariable(value = "Id") Long id) throws RessourceNotFoundException {
		com.vermeg.settelmentmodule.user user= UserRepository.findById(id)
				.orElseThrow(
						() -> new RessourceNotFoundException("user not found for this id :: " +id));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/user")
	public user createuser(@Valid @RequestBody user user  ) {
		return UserRepository.save(user);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<user> updateuser(@PathVariable(value = "Id") Long id,
			@Valid @RequestBody  com.vermeg.settelmentmodule.user  userDetails)
			throws RessourceNotFoundException {
		com.vermeg.settelmentmodule.user user = UserRepository.findById(id)
				.orElseThrow(
						() -> new RessourceNotFoundException("user not found for this id :: " + id));

		User.setId(userDetails.getId());
		User.setNom(userDetails.getNom());
		User.setPrenom(userDetails.getPrenom());
		
		

		final com.vermeg.settelmentmodule.user  updateuser= UserRepository
				.save(user);
		return ResponseEntity.ok(updateuser);
	}

	@DeleteMapping("/user/{Id}")
	public Map<String, Boolean> deleteuser(@PathVariable(value = "Id") Long id)
	throws RessourceNotFoundException	{
		com.vermeg.settelmentmodule.user  user = UserRepository.findById(id)
				.orElseThrow(
						() -> new RessourceNotFoundException("user not found for this id : " + id));

		UserRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
