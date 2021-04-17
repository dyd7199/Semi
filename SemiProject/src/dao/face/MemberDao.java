package dao.face;

import java.sql.Connection;
import java.util.List;

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

	/**
<<<<<<< HEAD
	 * 모든 회원정보 조회
	 * 
	 * @param connection
	 * @return 회원 테이블 전체 데이터
	 */
	List<Member> getAllUser(Connection conn);

	Member getUserno(Connection conn, Member m);

	/**
	 * id로 id가 있는지 조회 있으면  중복
	 * @param connection
	 * @param userid
	 * @return
	 */
	int selectById(Connection conn, String userid);
	/**
	 * nick로 nick이 있는지 조회 있으면 중복
	 * @param connection
	 * @param nick
	 * @return
	 */
	int selectByNick(Connection conn, String nick);

}
