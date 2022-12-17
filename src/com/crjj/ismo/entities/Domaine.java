package com.crjj.ismo.entities;

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
@ToString(onlyExplicitlyIncluded = true)
public class Domaine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_domaine")
	@ToString.Include
	private int numero; 
	
	@Column(name = "nom_domaine")
	@ToString.Include
	private String nom;
	
	@OneToMany(mappedBy = "domaine")
	private List<Invention> inventions; 
}
