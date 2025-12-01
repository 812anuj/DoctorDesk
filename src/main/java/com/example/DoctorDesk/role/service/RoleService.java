package com.example.DoctorDesk.role.service;

import java.util.List;

import com.example.DoctorDesk.res.Response;
import com.example.DoctorDesk.role.entity.Role;

public interface RoleService {

    Response<Role> createRole(Role roleRequest);

    Response<Role> updateRole(Role roleRequest);

    Response<List<Role>> getAllRoles();

    Response<?> deleteRole(Long id);
}
