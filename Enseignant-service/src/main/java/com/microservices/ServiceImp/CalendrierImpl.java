package com.microservices.ServiceImp;


import com.microservices.Repository.EnseignantRepository;
import com.microservices.Repository.SeanceRepository;
import com.microservices.Service.CalendrierService;
import com.microservices.model.Enseignant;
import com.microservices.model.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CalendrierImpl implements CalendrierService {

	@Autowired
	SeanceRepository seanceRepository;

	@Autowired
	EnseignantRepository enseignantRepository;





	@Override
	public List<Seance> addSeanceToEnseignant(String codeS, long id) {
		try {
			Seance sc=seanceRepository.findByCodeS(codeS);
			Enseignant en=enseignantRepository.findById(id);
			if(en!=null)
			{
				if(sc!=null)
				{
					List<Seance> ls=en.getLstSeance();
					if(ls==null)
					{
						ls=new ArrayList<Seance>();
						ls.add(sc);
						en.setLstSeance(ls);

					}
					else
					{
						ls.add(sc);
					}
					enseignantRepository.flush();

					return ls;
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}





}
