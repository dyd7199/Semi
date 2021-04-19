package dao.face;

import java.sql.Connection;
import java.util.List;

import review.dto.Seoul;

public interface RestaurantDao {

	public List<Seoul> selectByTopRest(Connection conn);


}
