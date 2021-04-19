package review.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import review.dto.BoardFile;
import review.dto.Review;
import review.util.Paging;

public interface ReviewService {

	/**
	 * 페이징 객체 생성
	 * @param curPage정보를 담고 있는 요청정보 객체
	 * @return 페이징 계산이 완료된 Paging 객체
	 */
	Paging getPaging(HttpServletRequest req);

	/**
	 * 게시글 전체 조회
	 * @param paging
	 * @return List<Review> 
	 */
	List<Review> getList(Paging paging);

	/**
	 * 요청 파라미터 얻기
	 * @param req
	 * @return 전달 파라미터 reviewno을 포함한 객체
	 */
	Review getReviewno(HttpServletRequest req);

	/**
	 * 주어진 reviewno을 이용하여 상세 정보 조회
	 * @param reviewno
	 * @return
	 */
	Review view(Review reviewno);

	/**
	 * 게시글 작성
	 * @param req 요청정보 객체(게시글내용 + 첨부파일)
	 */
	void write(HttpServletRequest req);

	/**
	 * 게시글 삭제
	 * @param review
	 */
	void delete(Review review);

	/**
	 * 게시글 수정
	 * @param req
	 */
	void update(HttpServletRequest req);

	/**
	 * 첨부파일 정보얻기
	 * @param viewReview - 첨부파일이 포함된 리뷰 번호
	 * @return 첨부파일 정보 객체
	 */
	BoardFile viewFile(Review viewReview);

}
