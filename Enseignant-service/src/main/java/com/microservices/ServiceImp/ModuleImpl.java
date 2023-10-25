package com.microservices.ServiceImp;


import com.microservices.Repository.ModuleRepository;

import com.microservices.Service.ModuleService;

import com.microservices.model.Modulee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleImpl implements ModuleService {

	@Autowired
	ModuleRepository moduleRepository;

	@Override
	public String addModule(Modulee module) {
		try {

			if(moduleRepository.findByCodeM(module.getCodeM())!=null)
				return "fail";
			if(moduleRepository.save(module)!=null)
				return "success";
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String updateModule(Modulee module) {
		Modulee ins=moduleRepository.findByCodeM(module.getCodeM());
		if(ins!=null)
		{
			if(moduleRepository.save(module)!=null)
				return "success";
		}
		return "fail";
	}

	@Override
	public String deleteModule(Modulee module) {
		String codeM=module.getCodeM();
		moduleRepository.delete(module);

		if(moduleRepository.findByCodeM(codeM)==null)
			return "success";

		return "fail";
	}

	@Override
	public Modulee getOneModule(String codeM) {
		try {
			Modulee mo=moduleRepository.findByCodeM(codeM);
			if (mo!=null) {
				return mo;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Modulee> getAll() {

		return moduleRepository.findAll();
	}


}
