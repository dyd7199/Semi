package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Review;
import dto.SeoulGrade;
import review.service.face.ReviewService;
import review.service.impl.ReviewServiceImpl;

@WebServlet("/mypage/review")
public class MyPageReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewService reviewService = new ReviewServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//해당 회원이 작성한 리뷰리스트를 가져올 기준 값 userno 추출
		Object userno1 = req.getSession().getAttribute("userno");
		int userno = (int) userno1;
		
		//리스트를 담을 객체 생성
		List<Review> list = new ArrayList<>();
		
		//로그인한 회원이 작성한 리뷰리스트
		list = reviewService.getMadeList(userno);
		
		req.setAttribute("list", list);
		
		List<SeoulGrade> nList = new ArrayList<>();
		nList = reviewService.getSeoul();
		
		req.setAttribute("nList", nList);
		
		//JSP 연결
		req.getRequestDispatcher("/WEB-INF/views/mypage/reviewmain.jsp")
			.forward(req, resp);
		
	}
}
