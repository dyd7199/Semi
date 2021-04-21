package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;
import service.face.FaqService;
import service.impl.FaqServiceImpl;

@WebServlet("/faq/view")
public class FAQViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FaqService faqService = new FaqServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" /faq/view - [GET] ");
	
		Faq faq = new Faq();
		
		faq = faqService.View();
		
		req.setAttribute("faq", faq);
	
		req.getRequestDispatcher("/WEB-INF/views/faq/list.jsp").forward(req, resp);
	
	}
	
		
	
}
