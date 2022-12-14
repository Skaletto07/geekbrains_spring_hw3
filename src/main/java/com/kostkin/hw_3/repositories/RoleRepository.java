package com.kostkin.hw_3.repositories;

import com.kostkin.hw_3.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}