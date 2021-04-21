package review.dao.face;

import java.sql.Connection;
import java.util.List;

import dto.SeoulGrade;
import review.dto.BoardFile;
import review.dto.Review;
import review.dto.Seoul;
import review.util.Paging;

public interface ReviewDao {

	/**
	 * 총 게시글 조회
	 * @param conn
	 * @return 총 게시글 수 cnt
	 */
	public int selectCntAll(Connection conn);

	/**
	 * 리뷰 테이블 전체 조회
	 * @param conn
	 * @param paging 페이징 정보 객체
	 * @return List<Review> 전체 조회 결과 리스트
	 */
	public List<Review> selectAll(Connection conn, Paging paging, Seoul upso_sno);

	/**
	 * 선택된 리뷰 조회
	 * @param conn
	 * @param reviewno -조회할 reviewno을 가진 객체
	 * @return review 조회된 결과 객체
	 */
	public Review selectReviewByReviewno(Connection conn, Review reviewno);

	/**
	 * 게시글 입력
	 * @param conn
	 * @param review
	 * @return
	 */
	public int insert(Connection conn, Review review);

	/**
	 * 게시글 삭제
	 * @param conn
	 * @param review
	 * @return
	 */
	public int delete(Connection conn, Review review);

	/**
	 * 게시글 수정
	 * @param conn
	 * @param review
	 * @return
	 */
	public int update(Connection conn, Review review);

	/**
	 * 다음 게시글 번호 반환
	 *  게시글 테이블과 첨부파일 테이블에 입력될 게시글번호를
	 * 시퀀스를 통해 추출한다
	 * @param conn
	 * @return 다음 게시글 번호
	 */
	public int selectReviewno(Connection conn);

	/**
	 * 첨부파일 입력
	 * @param conn
	 * @param boardFile
	 * @return
	 */
	public int insertFile(Connection conn, BoardFile boardFile);

	/**
	 * 첨부파일 조회
	 * @param connection
	 * @param viewReview
	 * @return
	 */
	public BoardFile selectFile(Connection connection, Review viewReview);

	/**
	 * 로그인한 회원의 모든 리뷰리스트 반환
	 * 
	 * @param conn DB연결 객체
	 * @param userno 로그인한 회원의 회원번호
	 * @return 해당 회원이 작성한 모든 리뷰리스트
	 */
	public List<Review> getListByUserno(Connection conn, int userno);

	/**
	 * 상점리스트를 불러온다
	 * 
	 * @param conn
	 * @param userno
	 * @return
	 */
	public List<SeoulGrade> getSeoul(Connection conn);


	
}
