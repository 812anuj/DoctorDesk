package com.example.DoctorDesk.users.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DoctorDesk.users.Entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
