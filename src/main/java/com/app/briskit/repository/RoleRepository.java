package com.app.briskit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.briskit.model.RoleEB;

public interface RoleRepository extends JpaRepository<RoleEB, Long> {
	
	@Query(value = "select r from RoleEB r where r.code=:code and r.deleted='N' ", nativeQuery = false)
	RoleEB findRoleByCode(@Param(value = "code") String code);
}
