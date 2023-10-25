package com.microservices.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity
@Table(schema = "Formulaire")
public class Formulaire {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String Nom;
    private String email;
    private String descrp;
    private String classe;

    @ManyToOne(cascade = CascadeType.ALL)
    private Club club;


}
