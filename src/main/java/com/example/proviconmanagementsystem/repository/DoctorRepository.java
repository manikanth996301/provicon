package com.example.proviconmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proviconmanagementsystem.modal.Doctor;

public interface DoctorRepository  extends JpaRepository<Doctor, Long>{
boolean existsBydoctorName(String doctorName);
}
