package com.microservices.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
public class Enseignant  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Seance> lstSeance;





}
