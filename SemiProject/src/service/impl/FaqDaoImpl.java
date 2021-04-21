package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dto.Faq;

public class FaqDaoImpl implements FaqDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public Faq getData(Connection conn) {

		String sql = "";
		sql += "SELECT * FROM FAQ";

		Faq faq = new Faq();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery(sql);
			
			while( rs.next() ) {
				
				
				faq.setTitle( rs.getString("title") );
				faq.setInq_content( rs.getString("inq_content") );
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
		return faq;
	}

}
