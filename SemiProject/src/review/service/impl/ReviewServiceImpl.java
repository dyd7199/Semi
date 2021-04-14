package review.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import review.common.JDBCTemplate;
import review.dao.face.ReviewDao;
import review.dao.impl.ReviewDaoImpl;
import review.dto.Review;
import review.service.face.ReviewService;
import review.util.Paging;

public class ReviewServiceImpl implements ReviewService {
	private ReviewDao reviewDao = new ReviewDaoImpl();
		
	@Override
	public Paging getPaging(HttpServletRequest req) {
		//전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
		curPage = Integer.parseInt(param);
				}
		//Review 테이블의 총 게시글 수를 조회한다
		int totalCount = reviewDao.selectCntAll(JDBCTemplate.getConnection());
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
				
		return paging;
	}

	@Override
	public List<Review> getList(Paging paging) {
		return reviewDao.selectAll(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public Review getReviewno(HttpServletRequest req) {
		//reviewno를 저장할 객체 생성
		Review reviewno = new Review();
		//boardno 전달파라미터 검증 - null, ""
		String param = req.getParameter("reviewno");
		if(param!=null && !"".equals(param)) {
			
			reviewno.setReviewno(Integer.parseInt(param));
		}
		return reviewno;
	}

	@Override
	public Review view(Review reviewno) {
		Connection conn = JDBCTemplate.getConnection();
		
		Review review = reviewDao.selectReviewByReviewno(conn, reviewno); 
		
		return review;
	}

	@Override
	public void write(HttpServletRequest req) {
		Review review = new Review();

		review.setTitle( req.getParameter("title") );
		review.setInq_content( req.getParameter("inq_content") );


		review.setUserno((int) req.getSession().getAttribute("userno"));

		if(review.getTitle()==null || "".equals(review.getTitle())) {
			review.setTitle("(제목없음)");
		}

		Connection conn = JDBCTemplate.getConnection();
		if( reviewDao.insert(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}

	@Override
	public void delete(Review review) {
		Connection conn = JDBCTemplate.getConnection();
			
		
		if( reviewDao.delete(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
		
	

}
