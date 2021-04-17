package dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.Member;
import dto.Recipe;

public interface RecipeDao {

	List<Recipe> selectAll(Connection conn, Paging paging);

	/**
	 * 해당하는 게시글 번호의 모든 데이터를 가져온다
	 * 
	 * @param connection
	 * @return 한 행의 모든 데이터
	 */
	Recipe selectByPostno(Connection conn, String postno);

	int selectCntAll(Connection conn);

	int updateViews(Connection conn, String postno);

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



}
