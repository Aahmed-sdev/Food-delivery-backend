package com.app.briskit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.briskit.model.UsersEB;

public interface UsersRepository extends JpaRepository<UsersEB, Long>{
	@Query(value = "select u from UsersEB u where u.username=:username and u.deleted='N' ", nativeQuery = false)
	List<UsersEB> findUserByUsername(@Param(value = "username") String username);
	
	@Query(value = "select u from UsersEB u where u.phoneNo=phoneNo and u.deleted='N' ", nativeQuery = false)
	List<UsersEB> findUserByPhoneNo(@Param(value = "phoneNo") String phoneNo);
	
	@Query(value = "select u from UsersEB u where u.email =:email and u.deleted='N' ", nativeQuery = false)
	List<UsersEB> findUserByEmail(@Param(value = "email") String email);
}
