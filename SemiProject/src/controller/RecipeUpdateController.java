package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Recipe;
import service.face.MemberService;
import service.face.RecipeService;
import service.impl.MemberServiceImpl;
//github.com/dyd7199/Semi.git
import service.impl.RecipeServiceImpl;

/**
 * Servlet implementation class RecipeUpdateController
 */
@WebServlet("/recipe/update")
public class RecipeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	private RecipeService recipeService = new RecipeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//글번호에 해당하는 모든 정보 가져오기
		Recipe recipe = new Recipe();
		
		String userno = req.getParameter("userno");
		
		recipe = recipeService.getDataByUserno(userno);
		
		if( (boolean) memberService.UsernoChk(req) ) {
			
			System.out.println("로그인 한 회원과 글작성자 일치");
			
			req.getRequestDispatcher("/WEB-INF/views/board/recipe.update.jsp")
				.forward(req, resp);
			
		} else {
			
			System.out.println("로그인 한 회원과 글장석자 불일치");
			
		}
		
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Object no1 = req.getSession().getAttribute("userno");
		Object no2 = req.getParameter("userno");
		
		
		//로그인 한 회원과 작성자가 같지않으면 리다이렉트
		//게시글 데이터를 기준으로 유저넘버를 가져와야한다
		if( no1.equals(no2)) {
			//DB로부터 해당하는 글 번호의 모든 데이터 가져오기
			Recipe recipe = new Recipe();
			
			//수정할 때 기본적으로 입력되있는 제목과 본문 가져오기
			recipe = recipeService.getRecipeByUserno(req);
			
			req.setAttribute("recipe", recipe);
			
			req.getRequestDispatcher("/WEB-INF/views/board/recipe/update.jsp")
			.forward(req, resp);
		} else {
			
			resp.sendRedirect("/recipe/detail");			
		}
			
		
		
	}
}
