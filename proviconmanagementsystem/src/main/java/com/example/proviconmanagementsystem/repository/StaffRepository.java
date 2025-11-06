package com.example.proviconmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proviconmanagementsystem.modal.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{
boolean existsBystaffName(String staffName);
}
