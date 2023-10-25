package com.microservices.Controller;


import com.microservices.Service.SeanceService;
import com.microservices.model.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main/seance")
public class SeanceController {
	@Autowired
	SeanceService seanceService;

	@PostMapping("/add")
	public String addSeance(@RequestBody Seance seance) {
		return seanceService.addSeance(seance);
	}

	@PutMapping("/update")
	public String updateSeance(@RequestBody Seance seance) {
		return seanceService.updateSeance(seance);
	}

	@DeleteMapping("/delete")
	public String deleteSeance(@RequestParam String codeS) {
		return seanceService.deleteSeance(this.getSeance(codeS));
	}

	@GetMapping("/get")
	public Seance getSeance(@RequestParam String codeS) {
		return seanceService.getOneSeance(codeS);
	}

	@GetMapping("/getAll")
	public List<Seance> getAllSeance() {
		return seanceService.getAll();
	}
}
