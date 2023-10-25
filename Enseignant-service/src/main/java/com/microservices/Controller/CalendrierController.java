package com.microservices.Controller;


import com.microservices.Service.CalendrierService;
import com.microservices.model.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main/calendrier")
public class CalendrierController {

	@Autowired
	CalendrierService calendrierService;

	@PostMapping("/addSeanceToEnseignant")
	public List<Seance> addSeanceToEnseignant(@RequestParam String codeS, @RequestParam long id) {
		return calendrierService.addSeanceToEnseignant(codeS, id);
	}


}
