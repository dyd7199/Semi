package detail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detail")
public class DetailMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/detail [GET] 요청완료");
		
		req.getRequestDispatcher("/WEB-INF/views/detail/detailmain.jsp").forward(req, resp);
		}
   

}
