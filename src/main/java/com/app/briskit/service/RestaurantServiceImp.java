package com.app.briskit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.app.briskit.model.RestaurantsEB;
import com.app.briskit.repository.RestaurantRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RestaurantServiceImp implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public RestaurantsEB save(RestaurantsEB restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantsEB> findAllRestaurant() {
		return restaurantRepo.findAllRestaurant();
	}

}
