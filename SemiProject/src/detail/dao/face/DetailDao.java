package detail.dao.face;

import java.sql.Connection;

import review.dto.Seoul;

public interface DetailDao {

	Seoul selectUpsoByUpso_sno(Connection conn, Seoul upso_sno);

}
