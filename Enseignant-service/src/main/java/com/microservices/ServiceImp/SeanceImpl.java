package com.microservices.ServiceImp;

import com.microservices.Repository.EnseignantRepository;
import com.microservices.Repository.ModuleRepository;
import com.microservices.Repository.SeanceRepository;
import com.microservices.Service.SeanceService;
import com.microservices.model.Enseignant;
import com.microservices.model.Modulee;
import com.microservices.model.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceImpl implements SeanceService {

	@Autowired
	SeanceRepository seanceRepository;

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	EnseignantRepository  enseignantRepository;
	@Override
	public String addSeance(Seance seance) {
		try {


			Modulee mo=seance.getModule();//moduleRepository.findByCodeM(seance.getModule().getCodeM());
			seance.setModule(mo);

			Enseignant en=seance.getEnseignant();//enseignantRepository.findById(seance.getEnseignant().getId());
			seance.setEnseignant(en);



			if(seanceRepository.findByCodeS(seance.getCodeS())!=null)
				return "fail";

			if(seanceRepository.save(seance)!=null)
				return "success";

		} catch (Exception e) {

			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String updateSeance(Seance seance) {
		Seance ins=seanceRepository.findByCodeS(seance.getCodeS());
		if(ins!=null)
		{
			if(seanceRepository.save(seance)!=null)
				return "success";
		}
		return "fail";

	}

	@Override
	public String deleteSeance(Seance seance) {
		String codeS=seance.getCodeS();
		seanceRepository.delete(seance);

		if(seanceRepository.findByCodeS(codeS)==null)
			return "success";

		return "fail";
	}

	@Override
	public Seance getOneSeance(String codeS) {
		try {
			Seance se=seanceRepository.findByCodeS(codeS);
			if (se!=null) {
				return se;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Seance> getAll() {

		return seanceRepository.findAll();
	}

}
