package review.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import review.common.JDBCTemplate;
import review.dao.face.ReviewDao;
import review.dto.BoardFile;
import review.dto.Review;
import review.dto.Seoul;
import review.util.Paging;

public class ReviewDaoImpl implements ReviewDao {
	
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	@Override
	public int selectCntAll(Connection conn) {
//		System.out.println("selectCntAll() 호출");
		String sql = "";
		sql += "SELECT count(*) cnt FROM review";
		
		//총 게시글 수
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
			//cnt 확인
//			System.out.println(cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}
	@Override
	public List<Review> selectAll(Connection conn, Paging paging, Seoul upso_sno) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " 	SELECT rownum rnum, R.* FROM (";
		sql += " 		SELECT";
		sql += " 			reviewno, upso_sno, title, userno, inq_content, create_date, star_score";
		sql += " 		FROM review  WHERE = ?";
		sql += " 		ORDER BY reviewno DESC";
		sql += "	) R";
		sql += " ) REVIEW";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Review> reviewList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, upso_sno.getUpso_sno());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			//조회 결과 처리
			while(rs.next()) {
			Review r = new Review(); //결과값 저장 객체
			
			r.setReviewno(rs.getInt("reviewno"));
			r.setUpso_sno(rs.getString("upso_sno"));
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
				viewReview.setStar_score(rs.getInt("star_score"));
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
		
		String sql = "";
		sql += "INSERT INTO review(reviewno, title, userno, inq_content, star_score, upso_sno)";
		sql += " VALUES (?, ?, ?, ?, ?, ?)";
		int res = 0;
		
		//DB작업
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, review.getReviewno());
				ps.setString(2, review.getTitle());
				ps.setInt(3, review.getUserno());
				ps.setString(4, review.getInq_content());
				ps.setInt(5, review.getStar_score());
				ps.setString(6, review.getUpso_sno());
				
				res = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}
//		System.out.println("res:" + res);
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
	@Override
	public int update(Connection conn, Review review) {
		//다음 게시글 번호 조회 쿼리
				String sql = "";
				sql += "UPDATE review";
				sql += " SET title = ?,";
				sql += " 	inq_content = ?";
				sql += " WHERE reviewno = ?";
				
				//DB 객체
				PreparedStatement ps = null; 
				
				int res = -1;
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setString(1, review.getTitle());
					ps.setString(2, review.getInq_content());
					ps.setInt(3, review.getReviewno());

					res = ps.executeUpdate();
					System.out.println(res);
				} catch (SQLException e) {
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
	@Override
	public int selectReviewno(Connection conn) {
		//SQL 작성
				String sql = "";
				sql += "SELECT review_seq.nextval FROM dual";
				
				//결과 저장할 변수
				int reviewno = 0;
				
				try {
					ps = conn.prepareStatement(sql); //SQL수행 객체
					
					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
					//조회 결과 처리
					while(rs.next()) {
						reviewno = rs.getInt(1);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				
				//최종 결과 반환
				return reviewno;
	}
	@Override
	public int insertFile(Connection conn, BoardFile boardFile) {
		//다음 게시글 번호 조회 쿼리
				String sql = "";
				sql += "INSERT INTO boardfile(fileno, boardno, originname, storedname, filesize)";
				sql += " VALUES ( boardfile_seq.nextval, ?, ?, ?, ? )";
				
				int res = 0;
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);

					ps.setInt(1, boardFile.getBoardno());
					ps.setString(2, boardFile.getOriginName());
					ps.setString(3, boardFile.getStoredName());
					ps.setInt(4, boardFile.getFilesize());

					res = ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(ps);
				}
				
				return res;
			}
	@Override
	public BoardFile selectFile(Connection conn, Review viewReview) {
		//SQL 작성
				String sql = "";
				sql += "SELECT * FROM boardfile";
				sql += " WHERE boardno = ?";
				
				//결과 저장할 BoardFile 객체
				BoardFile boardFile = null;
				
				try {
					ps = conn.prepareStatement(sql); //SQL수행 객체
					
					ps.setInt(1, viewReview.getReviewno()); //조회할 boardno 적용
					
					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
					//조회 결과 처리
					while(rs.next()) {
						boardFile = new BoardFile();
						
						boardFile.setFileno( rs.getInt("fileno") );
						boardFile.setBoardno( rs.getInt("boardno") );
						boardFile.setOriginName( rs.getString("originname") );
						boardFile.setStoredName( rs.getString("storedname") );
						boardFile.setFilesize( rs.getInt("filesize") );
						boardFile.setWriteDate( rs.getDate("write_date") );
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				
				//최종 결과 반환
				return boardFile;
				
			}
	
	

}
