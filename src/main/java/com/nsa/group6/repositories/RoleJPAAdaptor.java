package com.nsa.group6.repositories;

import com.nsa.group6.domain.Role;
import com.nsa.group6.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleJPAAdaptor implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleJPAAdaptor(RoleRepository aRoleRepository) {
        roleRepository = aRoleRepository;
    }
    
    @Override
    public void saveRole(Role aRole) {

    }

    @Override
    public void updateRole(Role aRole) {

    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleByID(int roleID) {
        return roleRepository.findById(roleID);
    }

}
