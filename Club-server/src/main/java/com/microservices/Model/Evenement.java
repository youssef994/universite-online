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
@Table(schema = "Evenement")
public class Evenement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEvn;
    private String detailsEvenement;

    @Column(name = "datt")
    @Temporal(TemporalType.DATE)
    private Date datt;

    private Integer heureEvn;
    @ManyToOne(cascade = CascadeType.ALL)
    private Club club;
    private Integer prix;

}
