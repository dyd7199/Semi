package service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.dbcp.dbcp2.Jdbc41Bridge;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.Member;
import service.face.MemberService;

public class MemberServiceImpl implements MemberService {

	MemberDao memberDao = new MemberDaoImpl();
	@Override
	public Member getLoginMember(HttpServletRequest req) {
		
		// 객체 생성
		Member member = new Member();
		
		// 객체에 로그인 정보 삽입
		member.setUserid(req.getParameter("userid"));
		member.setUserpw(req.getParameter("userpw"));
		
		
		return member;
	}
	@Override
	public boolean login(Member member) {
		
		int res = memberDao.selectCntMemberUseridUserpw(JDBCTemplate.getConnection(),member);
		
		if(res>0) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Member info(Member member) {
		
		
		
		return memberDao.selectMemberByUserid(JDBCTemplate.getConnection(),member);
	}

}
