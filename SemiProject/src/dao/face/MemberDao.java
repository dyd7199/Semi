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
	 * 모든 회원정보 조회
	 * 
	 * @param connection
	 * @return 회원 테이블 전체 데이터
	 */
	List<Member> getAllUser(Connection conn);

	/**
	 * 레시피 작성에 필요한 userno를 매개변수 userid를 담고있는 Member m을 통해
	 * 가져온다
	 * 
	 * @param conn
	 * @param m userid를 담고있는 Member 객체
	 * @return 레시피 데이터에 들어갈 작성자의 userno
	 */
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

	/**
	 * 유저정보 조회
	 * @param connection
	 * @param member
	 * @return
	 */
	Member selectByUserInfo(Connection connection, Member member);

	/**
	 * 유저정보 업데이트
	 * @param connection
	 * @param member
	 * @return
	 */
	int updateByNickEmail(Connection connection, Member member);

	int delete(Connection connection, Object userid);

}
