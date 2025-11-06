package com.example.proviconmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proviconmanagementsystem.modal.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
boolean existsByclinicName(String clinicName);
}
