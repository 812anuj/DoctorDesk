package com.example.DoctorDesk.users.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.DoctorDesk.res.Response;
import com.example.DoctorDesk.users.Entity.User;
import com.example.DoctorDesk.users.dto.UpdatePasswordRequest;
import com.example.DoctorDesk.users.dto.UserDTO;

public interface UserService {


    User getCurrentUser();

    Response<UserDTO> getMyUserDetails();

    Response<UserDTO> getUserById(Long userId);

    Response<List<UserDTO>> getAllUsers();

    Response<?> updatePassword(UpdatePasswordRequest updatePasswordRequest);

    Response<?> uploadProfilePicture(MultipartFile file);

    Response<?> uploadProfilePictureToS3(MultipartFile file);

}
