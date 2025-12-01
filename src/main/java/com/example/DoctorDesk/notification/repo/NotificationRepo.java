package com.example.DoctorDesk.notification.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DoctorDesk.notification.entity.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
