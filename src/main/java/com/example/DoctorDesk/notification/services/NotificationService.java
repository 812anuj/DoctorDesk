package com.example.DoctorDesk.notification.services;

import com.example.DoctorDesk.notification.dto.NotificationDTO;
import com.example.DoctorDesk.users.Entity.User;

public interface NotificationService {
    void sendEmail(NotificationDTO notificationDTO, User user);
}
