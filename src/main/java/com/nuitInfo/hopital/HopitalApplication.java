package com.nuitInfo.hopital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nuitInfo.hopital.dao.PatientRepository;
import com.nuitInfo.hopital.dao.RegionRepository;
import com.nuitInfo.hopital.entity.Patient;
import com.nuitInfo.hopital.entity.Region;

@SpringBootApplication
public class HopitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);
		
	}
	/*
	 * @Bean CommandLineRunner start(PatientRepository pr, RegionRepository rp) {
	 * return args->{ Region r= new Region(null,"sousse",null);
	 * 
	 * rp.save(r); pr.save(new Patient(null,"ali","ali","h",true,r,null));
	 * pr.save(new Patient(null,"salah","ali","h",true,r,null)); pr.save(new
	 * Patient(null,"med","saah","h",false,r,null));
	 * 
	 * 
	 * pr.findAll().forEach(p->{ System.out.println(p.getNom()); });
	 * 
	 * pr.findVihByRegion(r.getId()).forEach(p->{ System.out.println(p.getNom());
	 * });
	 * 
	 * }; }
	 */
	
}
