package recipe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dto.Member;
import dto.Recipe;
import recipe.dao.face.RecipeDao;
import review.util.Paging;

public class RecipeDaoImpl implements RecipeDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM recipe";
		
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
	public List<Recipe> selectAll(Connection conn, Paging paging) {
		
		//SQL 구문 생성
		String sql = "";
		sql += "SELECT * FROM recipe";
		sql += "	ORDER BY postno DESC";
		
		//결과값 담을 List객체 생성
		List<Recipe> list = new ArrayList<>();
		
		try {
			//DB 객체 생성
			ps = conn.prepareStatement(sql);
			
			//SQL구문 수행
			rs = ps.executeQuery();
			
			//반복문으로 List에 DB데이터 담기
			while( rs.next() ) {
				
				//한 행의 데이터를 담을 객체 만들기
				Recipe r = new Recipe();
				
				r.setPostno( rs.getInt("postno") );
				r.setCreate_date( rs.getDate("create_date") );
				r.setTitle( rs.getString("title") );
				r.setUserno( rs.getInt("userno") );
				r.setInq_content( rs.getString("inq_content") );
				r.setViews( rs.getInt("views") );
				
				list.add(r);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return list;
	}

	@Override
	public Recipe selectByPostno(Connection conn, int post) {
		
		//SQL구문 생성
		String sql = "";
		sql += "SELECT * FROM recipe";
		sql += "	WHERE postno = ?";
		
		//리턴값 객체 생성
		Recipe recipe = new Recipe();
		
		try {
			//DB객체 연결
			ps = conn.prepareStatement(sql);
			
			// postno 값 대입
			ps.setInt(1, post);			
			
			//SQL쿼리 수행
			rs = ps.executeQuery();
			
			//결과값 대입
			while( rs.next() ) {
				
				recipe.setPostno( rs.getInt("postno") );
				recipe.setCreate_date( rs.getDate("create_date") );
				recipe.setTitle( rs.getString("title") );
				recipe.setUserno( rs.getInt("userno") );
				recipe.setInq_content( rs.getString("inq_content") );
				recipe.setViews( rs.getInt("views") );
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return recipe;
	}

	@Override
	public int updateViews(Connection conn, int post) {

		String sql = "";
		sql += "UPDATE recipe";
		sql += "	SET views = views + 1";
		sql += "	WHERE postno = ?";
		
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
		
		return res;
	}

	@Override
	public int insert(Connection conn, Recipe recipe, Member member) {

		String sql = "";
		sql += "INSERT INTO recipe( postno, create_date, title, userno, inq_content, views )";
		sql += "	VALUES ( recipe_seq.nextval, sysdate, ?, ?, ?, 0 )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, recipe.getTitle());
			ps.setInt(2, member.getUserno());
			ps.setString(3,  recipe.getInq_content());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
		return res;
	}

}


