package com.example.proviconmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proviconmanagementsystem.modal.DoctorSchdule;

public interface DoctorSchduleRepository extends JpaRepository<DoctorSchdule, Long>{
boolean existsByworkingDays(String workingDays);
}
