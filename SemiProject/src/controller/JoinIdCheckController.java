package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.face.MemberService;
import service.impl.MemberServiceImpl;

/**
 * Servlet implementation class JoinIdCheckController
 */
@WebServlet("/join/idcheck")
public class JoinIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("join/idcheck [POST]");
		resp.setContentType("application/json; charset=utf-8");
		System.out.println(req.getParameter("id"));
		
		
		int cnt = memberService.idcheck(req.getParameter("id"));
		
		System.out.println(cnt);
		
//		req.setAttribute("cnt", cnt);
        
        //타입을 json으로 바꿔줘야됨
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        
        
        
        String res = gson.toJson(cnt);
        
        resp.getWriter().write(res);
		
	}
}
