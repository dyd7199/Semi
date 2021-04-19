package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.FileDao;
import dto.ParamData;
import dto.UploadFile;

public class FileDaoImpl implements FileDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int insertParam(Connection conn, ParamData paramData) {
		
		String sql = "";
		sql += "INSERT INTO paramdata( datano, title )";
		sql += "	VALUES( paramdata_seq.nextval, ? )";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, paramData.getTitle());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}

	@Override
	public int insertFile(Connection conn, UploadFile uploadFile) {
		
		String sql = "";
		sql += "INSERT INTO uploadfile( fileno, origin_name, stored_name )";
		sql += "	VALUES( uploadfile_seq.nextval, ?, ? )";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uploadFile.getOriginName());
			ps.setString(2, uploadFile.getStoredName());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}		
		
		return result;
	}
}
