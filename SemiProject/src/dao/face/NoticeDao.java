package dao.face;

import java.sql.Connection;
import java.util.List;

import dao.Notice;

public interface NoticeDao {

	/**
	 * Notice 테이블 전체 조회 
	 * 
	 * @param conn
	 * @return List<Notice> - Notice테이블 전체 조회 결과리스트 
	 */
	public List<Notice> selectAll(Connection conn);

	/**
	 * 조회된 게시글의 조회수 증가   
	 * 
	 * @param postno 조회된 게시글 번호를 가진 객체   
	 */
	public int updateHit(Connection conn, int post);

	
	/**
	 * 
	 * 
	 * @param conn
	 * @param postno
	 * @return
	 */
	public Notice selectNoticeByPostno(Connection conn, int post);




	
	
}
