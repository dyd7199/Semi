package recipe.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Recipe;
import review.util.Paging;

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
	Recipe getRecipe(int post);

	Paging getPaging(HttpServletRequest req);

	void write(HttpServletRequest req);
	

}
