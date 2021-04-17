package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.Notice;
import dao.face.NoticeDao;

public class NoticeDaoImpl implements NoticeDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Notice> selectAll(Connection conn) {

		String sql = "";
		sql += "SELECT * FROM notice";
		sql += " ORDER BY postno";
		
		List<Notice> noticeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next()) {
				Notice n = new Notice();
				
				n.setPostno( rs.getInt("postno"));
				n.setCreate_date( rs.getDate("create_date"));
				n.setTitle( rs.getString("title"));
				n.setInq_content( rs.getString("inq_content"));
				n.setUserno( rs.getInt("userno"));
				n.setHit( rs.getInt("hit"));
				
				
				noticeList.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("noticeList : " + noticeList);
		
		return noticeList;
	}

	
	
	
	@Override
	public int updateHit(Connection conn, int post) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "UPDATE notice";
		sql += " SET hit = hit + 1";
		sql += " WHERE postno = ? ";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, post);
			
			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("res : " + res);
		return res;
	}

	
	
	@Override
	public Notice selectNoticeByPostno(Connection conn, int post) {
		
		
		String sql = "";
		sql += "SELECT * FROM notice";
		sql += " WHERE postno = ? ";
		
		Notice viewNotice = new Notice();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객
			
			ps.setInt(1, post); //조회할 게시글 번호 적
			
			rs = ps.executeQuery(); //SQL수행 및 결과집합 저장
			
			while( rs.next()) {
				viewNotice.setPostno( rs.getInt("postno"));
				viewNotice.setCreate_date( rs.getDate("create_date"));
				viewNotice.setTitle( rs.getString("title"));
				viewNotice.setInq_content( rs.getString("inq_content"));
				viewNotice.setUserno( rs.getInt("userno"));
				viewNotice.setHit( rs.getInt("hit"));
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		
		return viewNotice;
	}




}
