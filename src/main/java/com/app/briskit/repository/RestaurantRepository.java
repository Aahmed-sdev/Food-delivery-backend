package com.app.briskit.repository;

import java.time.LocalTime;
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
	
	@Query(value = "SELECT DISTINCT r.* FROM RESTAURANTS r " +
            "JOIN MENU_ITEMS m ON r.RESTAURANT_ID = m.RESTAURANT_ID " +
			" where m.SERVE_START_TIME IS NOT NULL and " +
            " :time BETWEEN m.SERVE_START_TIME and " +
            "COALESCE(m.SERVE_END_TIME, ADDTIME('24:00:00', m.SERVE_START_TIME))"
			, nativeQuery = true)
	List<RestaurantsEB> findAllRestaurantByTime(@Param(value = "time") LocalTime searchTime);
}
