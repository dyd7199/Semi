package detail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import detail.service.face.DetailService;
import detail.service.impl.DetailServiceImpl;
import review.dto.Seoul;


@WebServlet("/detail")
public class DetailMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetailService detailService = new DetailServiceImpl();
      
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/detail [GET] 요청완료");
		
		//전달 파라미터 얻기
		Seoul upso_sno = detailService.getupsono(req);
		Seoul viewupso = detailService.view(upso_sno);
		//조회결과 MODEL값 전달
		req.setAttribute("upso_sno", upso_sno);
		req.setAttribute("viewupso", viewupso);
		
		System.out.println(viewupso);
		req.getRequestDispatcher("/WEB-INF/views/detail/detailmain.jsp").forward(req, resp);
		}
   

}
