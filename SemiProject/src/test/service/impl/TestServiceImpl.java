package test.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import review.common.JDBCTemplate;
import review.dto.Seoul;
import test.dao.face.TestDao;
import test.dao.impl.TestDaoImpl;
import test.service.face.TestService;

public class TestServiceImpl implements TestService{
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	private TestDao testDao = new TestDaoImpl();
	@Override
	public List<Seoul> getList() {
		return testDao.selectList(JDBCTemplate.getConnection());
	}

}
