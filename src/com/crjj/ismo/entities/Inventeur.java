package com.crjj.ismo.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Inventeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_inventeur")
	private int id;
	
	@Column(name = "nom", nullable = false, length = 40)
	private String nom;
	
	@Column(name = "prenom", nullable = false, length = 40)
	private String prenom;
	
	@Column(name = "adresse", nullable = false, length = 40)
	private String adresse;
	
	@Column(name = "date_naiss")
	private LocalDate date_nas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "num_entreprise")
	private Entreprise entreprise;
	
	@OneToMany(mappedBy = "inventeur", fetch = FetchType.EAGER)
	private List<Brevet> brevets;
	
}
