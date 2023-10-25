package com.microservices.ServiceImp;

import com.microservices.Repository.EnseignantRepository;

import com.microservices.Service.EnseignantService;

import com.microservices.model.Enseignant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnseignantImpl implements EnseignantService {

	@Autowired
	EnseignantRepository enseignantRepository;

	@Override
	public String addEnseignant(Enseignant enseignant) {
		try {
			if (enseignantRepository.save(enseignant) != null) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}




	@Override
	public String deleteEnseignant(Enseignant enseignant) {
		long id=enseignant.getId();
		enseignantRepository.delete(enseignant);

		if(enseignantRepository.findById(id)==null)
			return "success";

		return "fail";
	}

	@Override
	public Enseignant getOneEnseignant(long id) {
		try {
			Enseignant en=enseignantRepository.findById(id);
			if (en!=null) {
				return en;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Enseignant> getAll() {

		return enseignantRepository.findAll();
	}

}
