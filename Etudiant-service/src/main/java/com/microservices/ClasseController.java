package com.microservices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ControllerClasse")
public class ClasseController {

    private  final  ClasseRepository classeRepository;

    public ClasseController(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Classe> ajouterClasse(@RequestBody Classe classe) {
        Classe nouvelleClasse = classeRepository.save(classe);
        return new ResponseEntity<>(nouvelleClasse, HttpStatus.CREATED);
    }


    // Endpoint pour mettre à jour une classe par son ID
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Classe> modifierClasse(@PathVariable Long id, @RequestBody Classe classeModifiee) {
        // Vérifier si la classe existe dans la base de données
        if (!classeRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Récupérer la classe existante
        Classe classeExistante = classeRepository.findById(id).get();




        // Mettre à jour les propriétés de la classe existante avec les nouvelles valeurs
        classeExistante.setNiveau(classeModifiee.getNiveau());
        classeExistante.setSpecialite(classeModifiee.getSpecialite());
        classeExistante.setNumero(classeModifiee.getNumero());
        classeExistante.setNomClasse(classeExistante.getNomClasse());


        // Enregistrer les modifications dans la base de données
        classeRepository.save(classeExistante);

        return new ResponseEntity<>(classeExistante, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Classe>> consulterTousLesEtudiants() {
        List<Classe> classes = classeRepository.findAll();

        if (classes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(classes, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteClasse(@PathVariable Long id) {
        classeRepository.deleteById(id);
    }

}
