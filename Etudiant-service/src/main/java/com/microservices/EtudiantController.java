package com.microservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ControllerEtudiants")
public class EtudiantController {

   private  final  ClasseRepository classeRepository;
   private  final EtudiantRepository etudiantRepository;
    private final EmailService emailService;

    public EtudiantController(ClasseRepository classeRepository, EtudiantRepository etudiantRepository
            , EmailService emailService
                              ) {
        this.classeRepository = classeRepository;
        this.etudiantRepository = etudiantRepository;
       this.emailService = emailService;
    }


    @PostMapping("/add/{classId}")
    public Etudiant addStudentWithClass(@RequestBody Etudiant student, @PathVariable Long classId) {

        Classe classe = classeRepository.findById(classId).orElse(null);

        if (classe != null ) {
            student.setClasse(classe);

            student.setIdentifiant(student.getIdentifiant());
            student.setNom(student.getNom());
            student.setPrenom(student.getPrenom());
            student.setAge(student.getAge());
            student.setMail(student.getMail());

            // Envoi de l'e-mail
            String to = student.getMail();
            String subject = "INSCRIPTION";
            String text = "Votre inscription est validé avec succès";
            emailService.sendEmail(to, subject, text);

         return   etudiantRepository.save(student);


        } else {
            throw new RuntimeException("Classe n'existent pas.");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Etudiant> modifierEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantModifie) {
        // Vérifier si l'étudiant existe dans la base de données
        if (!etudiantRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Récupérer l'étudiant existant
        Etudiant etudiantExist = etudiantRepository.findById(id).get();

        // Mettre à jour les propriétés de l'étudiant existant avec les nouvelles valeurs
        etudiantExist.setIdentifiant(etudiantExist.getIdentifiant());
        etudiantExist.setNom(etudiantModifie.getNom());
        etudiantExist.setPrenom(etudiantModifie.getPrenom());
        etudiantExist.setAge(etudiantModifie.getAge());
         etudiantExist.setMail(etudiantModifie.getMail());

        // Enregistrer les modifications dans la base de données
        etudiantRepository.save(etudiantExist);

        return new ResponseEntity<>(etudiantExist, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Etudiant>> consulterTousLesEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();

        if (etudiants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantRepository.deleteById(id);
    }



}
