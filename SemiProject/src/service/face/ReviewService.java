package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.PagingReview;
import dto.Member;
import dto.Review;
import dto.Seoul;

public interface ReviewService {

	/** 
	 * 페이징 파라미터 받기
	 * @param req
	 * @return paging
	 */
	PagingReview getPaging(HttpServletRequest req);

	/**
	 * 페이징, 업소번호, 닉네임에 따른 리스트 조회
	 * @param paging
	 * @param upso_sno
	 * @param nick 
	 * @return reviewList
	 */
	List<Review> getList(PagingReview paging, Seoul upso_sno);
	
	/**
	 * 글작성
	 * @param req
	 * @param upso_sno 
	 */
	void write(HttpServletRequest req, Seoul upso_sno);

	/**
	 * 리뷰번호 가저오기
	 * @param req
	 * @return
	 */
	Review getReviewno(HttpServletRequest req);

	/**
	 * 글 수정
	 * @param req
	 */
	void update(HttpServletRequest req);

	/**
	 * 글 삭제
	 * @param review
	 */
	void delete(Review review);


}
