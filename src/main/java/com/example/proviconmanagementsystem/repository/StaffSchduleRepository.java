package com.example.proviconmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.proviconmanagementsystem.modal.StaffSchdule;

public interface StaffSchduleRepository extends JpaRepository<StaffSchdule, Long>{
boolean existsBydayOfWeek(String dayOfWeek);
}
