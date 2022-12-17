package com.crjj.ismo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString(onlyExplicitlyIncluded = true	)
public class Entreprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_entreprise")
	@ToString.Include
	private int numero;
	
	@Column(name = "nom_entreprise", nullable = false, length = 40)
	@ToString.Include
	private String nom;
	
	@Column(name = "activite", nullable = false, length = 40)
	@ToString.Include
	private String activite;
	
	@Column
	@ToString.Include
	private double ca;
	
	@Column(name = "ville", nullable = false, length = 40)
	@ToString.Include
	private String ville;  
	
	@OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
	List<Inventeur> inventeurs;
	
}
