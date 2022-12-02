package com.nuitInfo.hopital.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String nom ;
	private String prenom ;
	private String sexe;
	private Boolean vih;
	
	@ManyToOne
	private Region region;
	
	
	@ManyToMany(mappedBy = "patients" , fetch=FetchType.EAGER)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Medicamment> medicamment = new ArrayList<>();
}
