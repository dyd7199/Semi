package service.impl;

import java.util.List;

import common.JDBCTemplate;
import dao.face.RestaurantDao;
import dao.impl.RestaurantDaoImpl;
import review.dto.Seoul;
import service.face.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {
	RestaurantDao restaurantDao = new RestaurantDaoImpl();
	@Override
	public List<Seoul> getTopRest() {
		return restaurantDao.selectByTopRest(JDBCTemplate.getConnection());
	}

}
