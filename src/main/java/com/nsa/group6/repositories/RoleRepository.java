package com.nsa.group6.repositories;

import com.nsa.group6.domain.Role;
import com.nsa.group6.domain.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
