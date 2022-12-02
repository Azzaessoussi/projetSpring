package com.nuitInfo.hopital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nuitInfo.hopital.entity.Patient;
import com.nuitInfo.hopital.entity.Region;


@RepositoryRestResource
public interface PatientRepository extends JpaRepository<Patient, Long> {
//List<Patient> findByVihAndNom(boolean m , String n);
	
	
	//@RestResource(path="/patientVihByRegion")
	@Query("select p from Patient p where p.vih=true and p.region.id=:x")
	List<Patient> findVihByRegion(@Param(value="x") Long ID);
}
