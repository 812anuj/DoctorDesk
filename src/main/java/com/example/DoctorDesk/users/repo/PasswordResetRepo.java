package com.example.DoctorDesk.users.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DoctorDesk.users.Entity.PasswordResetCode;

public interface PasswordResetRepo extends JpaRepository<PasswordResetCode, Long> {
    Optional<PasswordResetCode> findByCode(String code);

    void deleteByCode(Long userId);

}
