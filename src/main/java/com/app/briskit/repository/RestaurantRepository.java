package com.app.briskit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.briskit.model.RestaurantsEB;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantsEB, Long>{
	@Query("SELECT r from restaurants r WHERE r.menuItems.menuItemsId = ?1")
	List<RestaurantsEB> findRestaurantByMenuId(long menuId);
	
	//@Query("SELECT r from restaurants r WHERE r.deleted = 'N' LIMIT ?1 OFFSET ?2 ")
	//List<RestaurantsEB> findAllrestaurantByPagination(int limit, int offset );
}
