package com.microservices.Services;
import com.microservices.Model.Club;
import com.microservices.Model.Formulaire;
import com.microservices.Repositories.clubRepository;
import com.microservices.Repositories.formulaireRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class formulaireService {
    private final formulaireRepository fr;


    public List<Formulaire> AllFormulaire(){return (List<Formulaire>) fr.findAll();}

    public Formulaire AddFormulaire(Formulaire form){
        return fr.save(form);
    }

    /*public Formulaire updateClub (Club  club){
        return clubRepository.save(club);
    }*/
   /* public void Delete(Integer idE){

        Club b = clubRepository.findById(idE).orElse(null);
        clubRepository.delete(b);
    }*/
}
