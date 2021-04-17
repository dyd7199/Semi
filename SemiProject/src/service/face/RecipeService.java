package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Recipe;

public interface RecipeService {

	/**
	 * 모든 레시피 게시판의 글을 가져온다
	 * @param paging 
	 * 
	 * @return 레시피 테이블의 모든 데이터
	 */
	List<Recipe> getRecipeList(Paging paging);
	
	/**
	 * 해당 글 번호의 상세데이터를 가져온다
	 * 
	 * @return 해당 글 번호의 모든 데이터
	 */
	Recipe getRecipe(String postno);

	Paging getPaging(HttpServletRequest req);

	void write(HttpServletRequest req);

	/**
	 * Userno로 해당 Recipe의 모든 정보를 가져온다
	 * 
	 * @param userno
	 * @return Userno에 해당하는 모든 Recipe
	 */
	Recipe getRecipeByUserno(HttpServletRequest req);


}
