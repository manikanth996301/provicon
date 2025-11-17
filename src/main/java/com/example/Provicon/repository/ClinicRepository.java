package com.example.Provicon.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Provicon.model.Clinic;
@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long>{

	

	

	Clinic findByclinicContact(String clinicContact);

	Clinic findByCliniName(String cliniName);

     boolean existsBycliniName(String cliniName);
}
