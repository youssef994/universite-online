package com.microservices.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import java.util.Date;

@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Seminaire {
    @Id
    private String id;
    private String nom;
    private String adresse;
    private Date date;
    private String Heure;
    private String prof;
    @DBRef
    private detailsSeminaire details;
}