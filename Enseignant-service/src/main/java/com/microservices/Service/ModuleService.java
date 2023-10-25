package com.microservices.Service;



import com.microservices.model.Modulee;

import java.util.List;

public interface ModuleService {
	String addModule(Modulee module);
	String updateModule(Modulee module);
	String deleteModule(Modulee module);
	Modulee getOneModule(String codeM);
	List<Modulee> getAll();
}
