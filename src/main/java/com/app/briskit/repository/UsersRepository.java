package com.app.briskit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.briskit.model.UsersEB;

public interface UsersRepository extends JpaRepository<UsersEB, Long>{

}
