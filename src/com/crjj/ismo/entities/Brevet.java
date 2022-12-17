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
public class Brevet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_brevet")
	@ToString.Include
	private int num;
	
	@Column(name = "description", nullable = false, length = 40)
	@ToString.Include
	private String description;
	
	@Column(name = "dateDepot")
	@ToString.Include
	private LocalDate dateDepot;
	
	@Column(name = "dateValidation")
	@ToString.Include
	private LocalDate dateValidation;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "num_inventeur")
	private Inventeur inventeur; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "num_invention")
	private Invention invention; 

}
