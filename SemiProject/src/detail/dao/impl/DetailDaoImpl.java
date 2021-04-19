package detail.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import detail.dao.face.DetailDao;
import review.common.JDBCTemplate;
import review.dto.Seoul;

public class DetailDaoImpl implements DetailDao {
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체

	@Override
	public Seoul selectUpsoByUpso_sno(Connection conn, Seoul upso_sno) {
		String sql = "";
		sql += "SELECT * FROM seoul WHERE upso_sno = ?";
		
		Seoul viewupso = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, upso_sno.getUpso_sno());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				viewupso = new Seoul();
				
//				viewupso.setCgg_code(rs.getString("cgg_code"));
				viewupso.setY_dents(rs.getString("y_dents"));
//				viewupso.setCob_code_nm(rs.getString("cob_code_nm"));
				viewupso.setX_cnts(rs.getString("x_cnts"));
//				viewupso.setCgg_code_nm(rs.getString("cgg_code_nm"));
				viewupso.setTel_no(rs.getString("tel_no"));
				viewupso.setBizcnd_code_nm(rs.getString("bizcnd_code_nm"));
//				viewupso.setUpso_sno(rs.getString("upso_sno"));
				viewupso.setFood_menu(rs.getString("food_menu"));
				viewupso.setUpso_nm(rs.getString("upso_nm"));
				viewupso.setRdn_code_nm("rdn_code_nm");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return viewupso;
	}

}
