package detail.dao.face;

import java.sql.Connection;

import review.dto.Seoul;

public interface DetailDao {

	/**업소번호에 따른 업소 선택
	 * 
	 * @param conn
	 * @param upso_sno
	 * @return
	 */
	Seoul selectUpsoByUpso_sno(Connection conn, Seoul upso_sno);

}
