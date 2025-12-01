package com.example.DoctorDesk.users.service;

import com.example.DoctorDesk.res.Response;
import com.example.DoctorDesk.users.dto.LoginRequest;
import com.example.DoctorDesk.users.dto.LoginResponse;
import com.example.DoctorDesk.users.dto.RegistrationRequest;
import com.example.DoctorDesk.users.dto.ResetPasswordRequest;

public interface AuthService {

    Response<String> register(RegistrationRequest request);

    Response<LoginResponse> login(LoginRequest loginRequest);

    Response<?> forgetPassword(String email);

    Response<?> updatePasswordViaResetCode(ResetPasswordRequest resetPasswordRequest);
}
