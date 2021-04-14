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

}
