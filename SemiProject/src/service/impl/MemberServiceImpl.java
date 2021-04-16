package service.impl;

import java.util.List;
<<<<<<< HEAD
=======


>>>>>>> branch 'master' of https://github.com/dyd7199/Semi.git
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
<<<<<<< HEAD
	
	
=======
>>>>>>> branch 'master' of https://github.com/dyd7199/Semi.git
	@Override
	public List<Member> getUserdata() {
		
		return memberDao.getAllUser(JDBCTemplate.getConnection());
<<<<<<< HEAD
	}
=======

	}
	
	
>>>>>>> branch 'master' of https://github.com/dyd7199/Semi.git
	@Override
	public Member getJoinMember(HttpServletRequest req) {
		
		
		
		
		Member member = new Member();
		System.out.println(req.getParameter("userid"));
		// 이메일
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		// 생년월일
		String birth = req.getParameter("year")+"-"+req.getParameter("month")+"-"+req.getParameter("day");
		
		
		
		
		
		
		
		member.setUserid(req.getParameter("userid"));
		member.setUserpw(req.getParameter("userpw"));
		member.setEmail(email);
		member.setUsername(req.getParameter("username"));
		member.setNick(req.getParameter("nick"));
		member.setPhoneno(req.getParameter("phoneno"));
		member.setUserbirth(birth);
		member.setGender(req.getParameter("gender"));
		member.setGrade("일반회원");
		
		
		
		
		
		
		return member;
	}
	@Override
	public void join(Member member) {
		if(memberDao.insertByMemberInfo(JDBCTemplate.getConnection(), member)>0) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		}
	}
	@Override
	public int idcheck(String userid) {
		return memberDao.selectById(JDBCTemplate.getConnection(),userid);
	}
	@Override
	public int nickcheck(String nick) {
		
		return memberDao.selectByNick(JDBCTemplate.getConnection(),nick);
<<<<<<< HEAD
=======
	}
	@Override
	public Member saveLoinId(Object userid) {
		
		Member member = new Member();
		member.setUserid((String)userid);
		
		
		return member;
	}
	@Override
	public Member getuserInfo(Member member) {
		// TODO Auto-generated method stub
		return memberDao.selectByUserInfo(JDBCTemplate.getConnection(), member);
>>>>>>> branch 'master' of https://github.com/dyd7199/Semi.git
	}

}
