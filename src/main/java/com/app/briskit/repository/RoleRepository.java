package com.app.briskit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.briskit.model.RoleEB;

public interface RoleRepository extends JpaRepository<RoleEB, Long> {
	
	@Query("select r from role r where r.code=:code and r.deleted='N' ")
	RoleEB findRoleByCode(@Param(value = "code") String code);
}
