package com.example.DoctorDesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableAsync
@RequiredArgsConstructor
public class DoctorDeskApplication {

	//private final NotificationService notificationService;
	public static void main(String[] args) {
		SpringApplication.run(DoctorDeskApplication.class, args);
	}

//  @Bean
//  CommandLineRunner runner() {
//   return args -> {
// 	NotificationDTO notificationDTO = NotificationDTO.builder()
// 			.recipient("contact.ra0info@gmail.com")
// 			.subject("Welcome to DAT Health!")
// 			.message("Thank you for registering Your account is ready.")
// 			.build();
// 			notificationService.sendEmail(notificationDTO, new User());
//  };}

}
