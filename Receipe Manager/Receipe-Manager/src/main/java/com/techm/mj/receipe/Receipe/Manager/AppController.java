package com.techm.mj.receipe.Receipe.Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppController {

	@Autowired
	private ReceipeRepository receipeRepository;

	@GetMapping("/receipes")
	public List < Receipe > getReceipes() {
		return receipeRepository.findAll();
	}

	@GetMapping("/receipes/{id}")
	public ResponseEntity < Receipe > getReceipeById(
			@PathVariable(value = "id") Long receipe_id) throws ResourceNotFoundException {
		Receipe receipe = receipeRepository.findById(receipe_id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + receipe_id));
		return ResponseEntity.ok().body(receipe);
	}

	@PostMapping("/receipes")
	public Receipe createReceipe(@Valid @RequestBody Receipe receipe) {
		return receipeRepository.save(receipe);
	}

	@PutMapping("/receipes/{id}")
	public ResponseEntity < Receipe > updateReceipe(
			@PathVariable(value = "id") Long receipe_id,
			@Valid @RequestBody Receipe userDetails) throws ResourceNotFoundException {
		Receipe receipe = receipeRepository.findById(receipe_id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + receipe_id));
		/*receipe.setFirstName(userDetails.getFirstName());
		receipe.setLastName(userDetails.getLastName());
		receipe.setEmail(userDetails.getEmail());*/
		final Receipe updatedReceipe = receipeRepository.save(receipe);
		return ResponseEntity.ok(updatedReceipe);
	}

	@DeleteMapping("/receipes/{id}")
	public Map < String, Boolean > deleteReceipe(
			@PathVariable(value = "id") Long receipe_id) throws ResourceNotFoundException {
		Receipe instructor = receipeRepository.findById(receipe_id)
				.orElseThrow(() -> new ResourceNotFoundException("receipe not found :: " + receipe_id));

		receipeRepository.delete(instructor);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
