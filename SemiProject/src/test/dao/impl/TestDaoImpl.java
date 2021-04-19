package test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import review.dto.Seoul;
import test.dao.face.TestDao;
import review.common.JDBCTemplate;

public class TestDaoImpl implements TestDao{
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체

	@Override
	public List<Seoul> selectList(Connection conn) {

		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM seoul WHERE upso_sno IN ('20060056233' , '19920056389' ,'20020053899')";
		
		List<Seoul> seoulList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Seoul s = new Seoul();
				
//				s.setCgg_code(rs.getString("cgg_code"));
//				s.setY_dnts(rs.getString("y_dnts"));
//				s.setCob_code_nm(rs.getString("cob_code_nm"));
//				s.setX_cnts(rs.getString("x_cnts"));
//				s.setCgg_code_nm(rs.getString("cgg_code_nm"));
//				s.setTel_no(rs.getString("tel_no"));
//				s.setBizcnd_code_nm(rs.getString("bizcnd_code_nm"));
				s.setUpso_sno(rs.getString("upso_sno"));
//				s.setFood_menu(rs.getString("food_menu"));
//				s.setUpso_nm(rs.getString("upso_nm"));
//				s.setRdn_code_nm("rdn_code_nm");
				
				seoulList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return seoulList;
	}

}
