package com.nuitInfo.hopital.web;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuitInfo.hopital.dao.PatientRepository;
import com.nuitInfo.hopital.dao.RegionRepository;
import com.nuitInfo.hopital.entity.Patient;
import com.nuitInfo.hopital.entity.Region;
import com.nuitInfo.hopital.entity.RegionNbMalade;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@AllArgsConstructor

public class PatientCotrolleur {
	PatientRepository pr;
	RegionRepository rr;
	
	//@GetMapping("/getAllPatients")
List<Patient> getPatients(){
		return pr.findAll();
	}
	
	//@GetMapping("/getAllPatients")
	List<Region> getRegion(){
			return rr.findAll();
		}
	
	
	
	//  @GetMapping("/getPatientsVihByRegion")
	 int getNbPatientVihByRegion(@PathVariable Long id ){ 
		  int nb =  pr.findVihByRegion(id).size();
		 
		  return nb;	  
	  }
	  
	 
	 
		  @GetMapping("/getPatientsVihByRegion")
	  List<RegionNbMalade> getList(){
		  
		  List<RegionNbMalade> liste= new ArrayList();
		  List<Region> regions = getRegion();
		  List<Patient> patients = getPatients();
		  
		  
		  for(Region region:regions){ 
			  int nb=0;
			  for(Patient patient : patients) {
				  if(patient.getRegion().getId() == region.getId() && patient.getVih()== true)
					  nb++;
				 }
			 
			 RegionNbMalade object= new RegionNbMalade( region.getNom() , nb);
			 liste.add(object);
			 
		  }
		  return liste;
	  }
	  
	  
	  
	 
}
