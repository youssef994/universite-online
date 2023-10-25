package com.microservices.Services;

import com.microservices.Model.Club;
import com.microservices.Repositories.clubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class clubService {


   private final clubRepository clubRepository;


   public List<Club> AllClubs(){return (List<Club>) clubRepository.findAll();}

   public Club AddClub(Club club){
      return clubRepository.save(club);
   }

   public Club updateClub (Club  club){
      return clubRepository.save(club);
   }
   public void Delete(Integer idE){

      Club b = clubRepository.findById(idE).orElse(null);
      clubRepository.delete(b);
   }
}
