package review.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import review.common.JDBCTemplate;
import review.dao.face.ReviewDao;
import review.dto.Review;
import review.util.Paging;

public class ReviewDaoImpl implements ReviewDao {
	
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	@Override
	public int selectCntAll(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM board";
		
		//총 게시글 수
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}
	@Override
	public List<Review> selectAll(Connection conn, Paging paging) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " 	SELECT rownum rnum, R.* FROM (";
		sql += " 		SELECT";
		sql += " 			reviewno, title, userno, inq_content, create_date, star_score";
		sql += " 		FROM review";
		sql += " 		ORDER BY reviewno DESC";
		sql += "	) R";
		sql += " ) REVIEW";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Review> reviewList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			//조회 결과 처리
			while(rs.next()) {
			Review r = new Review(); //결과값 저장 객체
			
			r.setReviewno(rs.getInt("reviewno"));
			r.setTitle(rs.getString("title"));
			r.setUserno(rs.getInt("userno"));
			r.setInq_content(rs.getString("inq_content"));
			r.setCreate_date(rs.getDate("create_date"));
			r.setStar_score(rs.getInt("star_score"));
			reviewList.add(r);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		//DB객체 닫기
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
		}
		return reviewList;
	}
	@Override
	public Review selectReviewByReviewno(Connection conn, Review reviewno) {
		
		String sql = "";
		sql += "SELECT reviewno, title, userno, inq_content, create_date, star_score FROM review WHERE reviewno = ?";
		
		Review viewReview = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reviewno.getReviewno());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				viewReview = new Review();
				
				viewReview.setReviewno(rs.getInt("reviewno"));
				viewReview.setUserno(rs.getInt("userno"));
				viewReview.setTitle(rs.getString("title"));
				viewReview.setInq_content(rs.getString("inq_content"));
				viewReview.setCreate_date(rs.getDate("create_date"));
				viewReview.setStar_score(rs.getInt("star_sore"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return viewReview;
	}
	@Override
	public int insert(Connection conn, Review review) {
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO review(reviewno, title, userno, inq_content, star_score)";
		sql += " VALUES (?, ?, ?, ?, ?)";
		int res = 0;
		
		//DB작업
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, review.getReviewno());
				ps.setString(2, review.getTitle());
				ps.setInt(3, review.getUserno());
				ps.setString(4, review.getInq_content());
				ps.setInt(5, review.getStar_score());
				
				res = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}
		
		return res;
	}
	@Override
	public int delete(Connection conn, Review review) {
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE review WHERE reviewno = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		int res = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getReviewno());
			
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return res;
	}

}
