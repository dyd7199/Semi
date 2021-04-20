package service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.RestaurantDao;
import dao.impl.RestaurantDaoImpl;
import dto.SeoulGrade;
import review.dto.Seoul;
import service.face.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {
	RestaurantDao restaurantDao = new RestaurantDaoImpl();
	@Override
	public List<Seoul> getTopRest() {
		return restaurantDao.selectByTopRest(JDBCTemplate.getConnection());
	}
	@Override
	public List<SeoulGrade> getTopRest(HttpServletRequest req) {
		
		List<SeoulGrade> list = restaurantDao.selectTopRestByTitle(JDBCTemplate.getConnection(), req);
		
		
		return list;
	}

}
