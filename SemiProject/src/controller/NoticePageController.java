package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Notice;
import service.face.NoticeService;
import service.impl.NoticeServiceImpl;

@WebServlet("/notice/list")
public class NoticePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/notice/list [get]");
	
		List<Notice> noticeList = noticeService.getList();
		
		req.setAttribute( "noticeList", noticeList);
		
//		System.out.println("noticeList : " + noticeList);
		req.getRequestDispatcher("/WEB-INF/views/board/notice.jsp").forward(req, resp);
		
	}
	
	
}
