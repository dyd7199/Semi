package service.face;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {

	/**
	 * 로그인 정보 저장 id,pw
	 * @param req
	 * @return
	 */
	public Member getLoginMember(HttpServletRequest req);

	/**
	 * 로그인 인증 
	 * @param member
	 * @return
	 */
	public boolean login(Member member);

	public Member info(Member member);
	/**
	 * 회원가입 정보저장
	 * @param req
	 * @return
	 */
	public Member getJoinMember(HttpServletRequest req);

	/**
	 * 저장된 회원정보 가입
	 * @param member - 저장된 회원정보
	 */
	public void join(Member member);
	/**
	 * 아이디 중복 체크
	 * @param parameter
	 * @return
	 */
	public int idcheck(String usrid);

}
