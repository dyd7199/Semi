package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.RecipeService;
import service.impl.RecipeServiceImpl;

@WebServlet("/recipe/write")
public class RecipeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecipeService recipeService = new RecipeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 되어있지 않으면 리다이렉트 
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/");
			
			return;
		}
		
		//JSP로 이동
		req.getRequestDispatcher("/WEB-INF/views/board/recipe/write.jsp")
			.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String str = (String) req.getSession().getAttribute("userid");
		System.out.println( str );
		
		String str1 = (String) req.getSession().getAttribute("usernick");
		System.out.println( str1 );
		
		String str2 = req.getParameter("title");
		String str3 = req.getParameter("content");
		
		System.out.println( str2 );
		System.out.println( str3 );
		
		//작성글 삽입
		recipeService.write(req);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/recipe/list");
		
	}
	
}
