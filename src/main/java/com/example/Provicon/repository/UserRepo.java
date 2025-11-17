package com.example.Provicon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Provicon.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);

}
