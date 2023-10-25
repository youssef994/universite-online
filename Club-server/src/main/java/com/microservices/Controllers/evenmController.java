package com.microservices.Controllers;

import com.microservices.Model.Evenement;
import com.microservices.Services.evenmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/evenm")
public class evenmController {

 private final evenmService evenmService;

 //http://localhost:8085/evenm/retrieve-all-evenm
    @GetMapping("/retrieve-all-evenm")
    public List<Evenement> getEvents() {
        List<Evenement> listEvnms = evenmService.AllEvents();
        return listEvnms;
    }

    @GetMapping("/Comming-events")
    public List<Evenement> CommingEvrnts() {
        List<Evenement> listEvnms = evenmService.AllCommingEvents();
        return listEvnms;
    }


    // http://localhost:8085/evenm/add-event
    @PostMapping("/add-event")
    public Evenement AddEvent(@RequestBody Evenement e){

            Evenement evnt = evenmService.AddEvent(e);
            return evnt;

    }
    // http://localhost:8085/evenm/Modify-event
    @PutMapping("/Modify-event")
    public Evenement ModifyEvent(@RequestBody Evenement e) {

        Evenement evnt = evenmService.AddEvent(e);
        return evnt;
    }
    // http://localhost:8085/evenm/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void DeleteEvent(@PathVariable("id") Integer Id ){
        evenmService.Delete(Id);
    }

}
