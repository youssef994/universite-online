package com.microservices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomClasse;
    private String niveau;
    private String specialite;
    private int numero;

    @OneToMany(mappedBy = "classe")
    @JsonIgnoreProperties("classe") // pour éviter Boucle infini
    private List<Etudiant> etudiants;

}
