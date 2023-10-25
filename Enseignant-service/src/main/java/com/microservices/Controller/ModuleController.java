package com.microservices.Controller;


import com.microservices.Service.ModuleService;
import com.microservices.model.Modulee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main/module")
public class ModuleController {
	@Autowired
	ModuleService moduleService;

	@PostMapping("/add")
	public String addModule(@RequestBody Modulee module) {
		return moduleService.addModule(module);
	}

	@PutMapping("/update")
	public String updateModule(@RequestBody Modulee module) {
		return moduleService.updateModule(module);
	}

	@DeleteMapping("/delete")
	public String deleteModule(@RequestParam String codeM) {
		return moduleService.deleteModule(this.getModule(codeM));
	}

	@GetMapping("/get")
	public Modulee getModule(@RequestParam String codeM) {
		return moduleService.getOneModule(codeM);
	}

	@GetMapping("/getAll")
	public List<Modulee> getAllModule() {
		return moduleService.getAll();
	}
}
