package com.example.proviconmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proviconmanagementsystem.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
Optional<User> findByuserName(String userName);
boolean existsByuserName(String userName);
}
