package com.microservices;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identifiant;
    private String nom;
    private String prenom;
    private int age;

    private String mail;



    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    public Etudiant(String nom, String prenom , int age ,String mail ) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.mail = mail;
    }

}
