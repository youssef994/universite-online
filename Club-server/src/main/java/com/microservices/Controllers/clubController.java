package com.microservices.Controllers;

import com.microservices.Model.Club;
import com.microservices.Services.clubService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")

public class clubController {

  private final  clubService clubService;
    //http://localhost:8085/club/retrieve-all-club


   @GetMapping("/retrieve-all-club")
    public List<Club> getClubs() {
        List<Club> listClubs = clubService.AllClubs();
        return listClubs;
    }
    // http://localhost:8085/club/add-club

    @PostMapping("/add-club")
    public Club AddClub(@RequestBody Club c){

        Club  club = clubService.AddClub(c);//.AddEvent(e);
        return club;

    }
    // http://localhost:8085/club/Modify-club
    @PutMapping("/Modify-club")
    public Club ModifyClub(@RequestBody Club c) {

        Club club = clubService.updateClub(c);
        return club;
    }
    // http://localhost:8085/club/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void DeleteClub(@PathVariable("id") Integer Id ){
        clubService.Delete(Id);
    }
}
