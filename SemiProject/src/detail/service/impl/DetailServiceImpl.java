package detail.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import detail.dao.face.DetailDao;
import detail.dao.impl.DetailDaoImpl;
import detail.service.face.DetailService;
import review.common.JDBCTemplate;
import review.dto.Seoul;

public class DetailServiceImpl implements DetailService{
	private DetailDao detailDao = new DetailDaoImpl();
	@Override
	public Seoul getupsono(HttpServletRequest req) {
		//upso_sno를 저장할 객체 생성
		Seoul upso_sno = new Seoul();
		//upso_sno 전달파라미터 검증 - null, ""
		String param = req.getParameter("upso_sno");
		if(param!=null && !"".equals(param)) {
			
			upso_sno.setUpso_sno(param);
		}
		return upso_sno;
	}

	@Override
	public Seoul view(Seoul upso_sno) {
		Connection conn = JDBCTemplate.getConnection();
		
		Seoul upso = detailDao.selectUpsoByUpso_sno(conn, upso_sno); 
		return upso;
	}

}
