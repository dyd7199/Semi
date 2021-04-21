package review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import detail.service.face.DetailService;
import detail.service.impl.DetailServiceImpl;
import review.dto.Review;
import review.dto.Seoul;
import review.service.face.ReviewService;
import review.service.impl.ReviewServiceImpl;
import review.util.Paging;


@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewService reviewService = new ReviewServiceImpl();
	private DetailService detailService = new DetailServiceImpl();

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/review/list [GET] 완료");
		
		//요청파라미터를 전달하여 Paging객체 생성하기
		Paging paging = reviewService.getPaging(req);
//		System.out.println("ReviewListController - " + paging);
		
		Seoul upso_sno = detailService.getupsono(req);
		//페이징을 적용한 게시글 조회
		List<Review> reviewList = reviewService.getList(paging, upso_sno);

		//페이징 객체를 MODEL값으로 전달
		req.setAttribute("paging", paging);
		
		//조회결과 MODEL값 전달
		req.setAttribute("reviewList", reviewList);
		
		req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
		
	}
}
