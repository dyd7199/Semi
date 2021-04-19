package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Inquiry;
import service.face.InquiryService;
import service.impl.InquiryServiceImpl;

@WebServlet("/mypage/inqview")
public class InquiryViewPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	InquiryService inquiryService = new InquiryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/inqview [GET]");
		
		//전달파라미터 얻기 - inquiryno
		Inquiry inquiryno = inquiryService.getInquiryno(req);
		
		//상세보기 결과 조회
		Inquiry viewInquiry = inquiryService.viewInq(inquiryno);
		
		//닉네임 전달
		req.setAttribute("nick", inquiryService.getNick(viewInquiry));
		
		//TEST 1)))
//		System.out.println("viewInquiry: " + viewInquiry);
		req.setAttribute("viewInquiry", viewInquiry);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/inquiryview.jsp").forward(req, resp);
	}
}
