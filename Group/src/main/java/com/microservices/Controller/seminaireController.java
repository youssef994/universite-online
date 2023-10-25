package com.microservices.Controller;

import com.microservices.Model.Seminaire;
import com.microservices.Model.detailsSeminaire;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.microservices.Repositories.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seminaire")
public class seminaireController {
    private final seminaireRep sr;
    private final detailsSeminaireRep dr;

    @GetMapping("/listSeminaire")
    public List<Seminaire> getAllSeminaire(){
        return sr.findAll();
    }
    @PostMapping("/add-seminaire")
    public Seminaire addSeminaire(@RequestBody Seminaire s)
    {
        return sr.save(s);
    }
    @DeleteMapping("/delete-seminaire/{id}")
    public void deleteSeminaire(@PathVariable String id)
    {
        Seminaire s = sr.findById(id).orElse(null);
        sr.delete(s);
    }
    @GetMapping("/listDetails")
    public List<detailsSeminaire> getAlldetails(){
        return dr.findAll();
    }
    @PostMapping("/add-details")
    public detailsSeminaire adddetails(@RequestBody detailsSeminaire s)
    {
        return dr.save(s);
    }
    @DeleteMapping("/delete-details/{id}")
    public void deletedetails(@PathVariable String id)
    {
        detailsSeminaire s = dr.findById(id).orElse(null);
        dr.delete(s);
    }



}