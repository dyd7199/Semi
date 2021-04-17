package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import dto.Recipe;
import service.face.MemberService;
import service.face.RecipeService;
import service.impl.MemberServiceImpl;
import service.impl.RecipeServiceImpl;

@WebServlet("/recipe/detail")
public class RecipeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RecipeService recipeService = new RecipeServiceImpl();
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터 객체 생성
		String postno = req.getParameter("postno");

		//글번호에 해당하는 글 상세데이터 객체 생성
		Recipe recipe = recipeService.getRecipe(postno);
		
		//세션에 속성값으로 Recipe 설정
		req.setAttribute("Recipe", recipe);
		
		//모든 회원정보를 받을 리스트 객체 생성
		List<Member> mList = new ArrayList<>();
		
		//모든 회원정보를 호출하기
		mList = memberService.getUserdata();

		//세션에 속성값으로 mList 설정
		req.setAttribute("mList", mList);
		
		//첨부파일 정보 생성
		
		
		//JSP로 연결
		req.getRequestDispatcher("/WEB-INF/views/board/recipe/detail.jsp")
			.forward(req, resp);
	}
	
}
