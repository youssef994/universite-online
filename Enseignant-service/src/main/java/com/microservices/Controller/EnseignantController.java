package com.microservices.Controller;


import com.microservices.Classe;
import com.microservices.Service.EnseignantService;
import com.microservices.model.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main/enseignant")
public class EnseignantController {
	@Autowired
	EnseignantService enseignantService;

	@Autowired
	private RestTemplate restTemplate; // Spring RestTemplate for making HTTP requests


	@PostMapping("/add")
	public String addEnseignant(@RequestBody Enseignant enseignant) {
		return enseignantService.addEnseignant(enseignant);
	}




	@DeleteMapping("/delete")
	public String deleteEnseignant(@RequestParam long id) {
		return enseignantService.deleteEnseignant(this.getEnseignant(id));
	}

	@GetMapping("/get")
	public Enseignant getEnseignant(@RequestParam long id) {
		return enseignantService.getOneEnseignant(id);
	}

	@GetMapping("/getAll")

	public List<Enseignant> getAllEnseignant() {
		return enseignantService.getAll();
	}


	@GetMapping("/getAllClasses")
	public List<Classe> getAllClasses() {

		String classeControllerUrl = "http://localhost:8083/ControllerClasse/all";

		//  HTTP GET request to the ClasseController
		ResponseEntity<List<Classe>> response = restTemplate.exchange(
				classeControllerUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Classe>>() {}
		);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			return new ArrayList<>();
		}
	}

}


