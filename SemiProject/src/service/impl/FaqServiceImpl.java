package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.JDBCTemplate;
import dto.Faq;
import service.face.FaqService;

public class FaqServiceImpl implements FaqService {

	private FaqDao faqDao = new FaqDaoImpl();
	private Connection conn = JDBCTemplate.getConnection();
	
	@Override
	public Faq View() {
		
		Faq faq = new Faq();
		
		faq = faqDao.getData(conn);
		
		return faq;
	}
	
}
