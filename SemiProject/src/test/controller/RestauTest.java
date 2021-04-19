package test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dto.Seoul;
import test.service.face.TestService;
import test.service.impl.TestServiceImpl;


@WebServlet("/test")
public class RestauTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TestService testService = new TestServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Seoul> seoulList = testService.getList();
		//조회결과 MODEL값 전달
		req.setAttribute("seoulList", seoulList);
		
		req.getRequestDispatcher("/WEB-INF/views/RestauTest.jsp").forward(req, resp);
		
	}
}
