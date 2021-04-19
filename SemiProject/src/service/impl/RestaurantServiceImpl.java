package service.impl;

import dao.face.RestaurantDao;
import dao.impl.RestaurantDaoImpl;
import dto.Restaurant;
import service.face.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {
	RestaurantDao restaurantDao = new RestaurantDaoImpl();
	@Override
	public Restaurant getTopRest() {
		return restaurantDao.selectByTopRest();
	}

}
