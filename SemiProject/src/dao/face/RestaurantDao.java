package dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.SeoulGrade;
import review.dto.Seoul;

public interface RestaurantDao {

	public List<Seoul> selectByTopRest(Connection conn);

	public List<SeoulGrade> selectTopRestByTitle(Connection connection, HttpServletRequest req);


}
