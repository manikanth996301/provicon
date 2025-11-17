package com.example.Provicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Provicon.model.DoctorSchdule;
@Repository
public interface DoctorschduleRepository extends JpaRepository<DoctorSchdule, Long> {

}
