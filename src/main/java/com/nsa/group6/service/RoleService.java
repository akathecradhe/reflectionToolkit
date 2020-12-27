package com.nsa.group6.service;

import com.nsa.group6.domain.Role;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

/**
 * Worked on by Clive
 */
@Service
public interface RoleService {
    public void saveRole(Role aRole);

    public void updateRole(Role aRole);

    List<Role> getAllRoles();

    public Optional<Role> getRoleByID(int ID);

}
