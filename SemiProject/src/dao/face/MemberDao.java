package dao.face;

import java.sql.Connection;

import dto.Member;

public interface MemberDao {
	/**
	 * ID, PW 비교해서 디비에 저장되어있는지 없는지 판단
	 * @param connection
	 * @param member 
	 * @return - 정보가 있으면 TRUE, 없으면 FALSE
	 */
	int selectCntMemberUseridUserpw(Connection conn, Member member);

	Member selectMemberByUserid(Connection conn, Member member);

	int insertByMemberInfo(Connection conn, Member member);

}
