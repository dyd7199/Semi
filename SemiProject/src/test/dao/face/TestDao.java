package test.dao.face;

import java.sql.Connection;
import java.util.List;

import review.dto.Seoul;

public interface TestDao {
	/**
	 * Seoul 일부 가져오기
	 * @param connection
	 * @return
	 */
	List<Seoul> selectList(Connection connection);

}
