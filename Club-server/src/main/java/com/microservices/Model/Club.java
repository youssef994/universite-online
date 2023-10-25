package com.microservices.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idClub;

    private String nom;
    private String descrp;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private String president;
    private String vicePresident;
    private String tresorier;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Evenement> evenements;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Formulaire> formulaires;




}
