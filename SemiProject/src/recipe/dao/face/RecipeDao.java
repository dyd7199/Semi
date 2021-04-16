package recipe.dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Member;
import dto.Recipe;
import review.util.Paging;

public interface RecipeDao {

	List<Recipe> selectAll(Connection conn, Paging paging);

	/**
	 * 해당하는 게시글 번호의 모든 데이터를 가져온다
	 * 
	 * @param connection
	 * @return 한 행의 모든 데이터
	 */
	Recipe selectByPostno(Connection conn, int post);

	int selectCntAll(Connection conn);

	int updateViews(Connection conn, int post);

	int insert(Connection conn, Recipe recipe, Member member);



}
