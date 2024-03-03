package com.app.briskit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.briskit.model.RestaurantsEB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantsEB, Long>{
	
	@Query("Select r from RestaurantsEB r where deleted = 'N'")
	List<RestaurantsEB> findAllRestaurant();
}
