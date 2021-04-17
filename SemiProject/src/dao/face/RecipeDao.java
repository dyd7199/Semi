package dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Member;
import dto.Recipe;

public interface RecipeDao {
	
	/**
	 * Recipe 테이블이 담고있는 모든 행의 수를 가져온다
	 * 
	 * @param conn DB연결 객체
	 * @return Recipe 테이블의 총 행의 수
	 */
	int selectCntAll(Connection conn);
	
	/**
	 * Paging으로 설정된 페이지당 보여질 수만큼의 게시글을 가져온다
	 * 
	 * @param conn DB연결 객체
	 * @param paging 게시글의 시작번호인 StartNo, 끝 번호인 EndNo
	 * @return 시작번호와 끝 번호를 포함한 사이의 모든 게시글
	 */
	List<Recipe> selectAll(Connection conn, Paging paging);

	/**
	 * 해당하는 게시글 번호의 모든 데이터를 가져온다
	 * 
	 * @param connection
	 * @return 한 행의 모든 데이터
	 */
	Recipe selectByPostno(Connection conn, String postno);

	/**
	 * 게시글의 상세내용을 볼 때 조회수를 1 올린다
	 * 
	 * @param con DB연결 객체
	 * @param postno 상세보기를 선택한 게시글의 번호
	 * @return 해당 게시글이 존재할 경우 1, 아닐 경우 0을 반환하여 조회수 증가 결정
	 */
	int updateViews(Connection conn, String postno);

	/**
	 * 작성된 게시글을 DB에 삽입한다
	 * 
	 * @param conn DB연결 객체
	 * @param recipe 회원이 작성한 게시글의 모든 데이터를 담고있는 객체
	 * @param member 게시글 신규 삽입을 위해 필요한 userno를 담고있는 객체
	 * @return 삽입 완료시 1, 실패시 0을 반환하여 DB commit 결정
	 */
	int insert(Connection conn, Recipe recipe, Member member);

	/**
	 * 레시피 상세보기에서 얻은 userno로 해당 recipe의 모든 정보를 가져온다
	 * 
	 * @param conn
	 * @param userno
	 * @return 해당 레시피 게시글의 모든 정보
	 */
	Recipe getDataByUserno(Connection conn, String userno);
	
	/**
	 * Userno를 이용해서 Recipe의 모든 데이터를 가져온다
	 * 
	 * @param conn
	 * @param userno 해당 게시글의 userno
	 * @return 해당 게시글의 Recipe객체
	 */
	Recipe getRecipeByUserno(Connection conn, int userno);

	/**
	 * 수정된 레시피 게시글의 모든 정보를 DB의 해당 게시글에 덮어씌운다
	 * 
	 * @param conn DB연결 객체
	 * @param req DB에 덮어씌울 수정된 레시피 게시글 데이터
	 * @return 
	 */
	int UpdateRecipe(Connection conn, HttpServletRequest req);

	/**
	 * 수정된 게시글의 postno를 이용하여 해당레시피의 모든 데이터를 받아온다
	 * 
	 * @param conn DB연결 객체
	 * @param postno 수정된 게시글의 번호
	 * @return 게시글 수정 완료 후 되돌아간 detail.jsp에서 보여줄 레시피 게시글의 모든 데이터
	 */
	Recipe getRecipeDataFromReq(Connection conn, int postno);

	/**
	 * 삭제요청된 게시글의 postno를 이용하여 해당 레시피의 모든 데이터를 지운다
	 * 
	 * @param conn DB연결 객체
	 * @param req 삭제할 게시글의 기준이되는 postno를 담고있는 객체
	 * @return postno가 일치하는 게시글이 있을 시 삭제하고 "1" 반환, 아닐시 "0" 반환
	 */
	int deleteRecipe(Connection conn, HttpServletRequest req);



}
