package com.microservices.Services;
import com.microservices.Model.Evenement;
import com.microservices.Repositories.evenmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class evenmService{
    private final evenmRepository evenmRepository;


    public List<Evenement> AllEvents(){return (List<Evenement>) evenmRepository.findAll();}
    public List<Evenement> AllCommingEvents(){
        return evenmRepository.findByDateAfter();
    }

    public Evenement AddEvent(Evenement evenement){
        return evenmRepository.save(evenement);
    }

    public Evenement updateEvent (Evenement  evenement){
        return evenmRepository.save(evenement);
    }
    public void Delete(Integer idE){

   Evenement e = evenmRepository.findById(idE).orElse(null);
   evenmRepository.delete(e);
    }
}
