package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminNoticeWrite
 */
@WebServlet("/admin/noticewrite")
public class AdminNoticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/noticewrite [get]");
		
//		if( req.getSession().getAttribute("login") == null ) {
//			
//			resp.sendRedirect("/");
//		}

		req.getRequestDispatcher("/WEB-INF/views/admin/admin_noticewrite.jsp").forward(req, resp);
		
	}
	
}
