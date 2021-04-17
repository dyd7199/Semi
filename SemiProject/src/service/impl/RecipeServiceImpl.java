package service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.MemberDao;
import dao.face.RecipeDao;
import dao.impl.MemberDaoImpl;
import dao.impl.RecipeDaoImpl;
import dto.Member;
import dto.Recipe;
import service.face.RecipeService;

public class RecipeServiceImpl implements RecipeService {

	private RecipeDao recipeDao = new RecipeDaoImpl();
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = recipeDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<Recipe> getRecipeList(Paging paging) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		return recipeDao.selectAll(conn, paging);
	}


	@Override
	public Recipe getRecipe(String postno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( recipeDao.updateViews(conn, postno) >= 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return recipeDao.selectByPostno(conn, postno);
	}

	@Override
	public void write(HttpServletRequest req) {

		Connection conn = JDBCTemplate.getConnection();

		Recipe recipe = new Recipe();

		recipe.setTitle( req.getParameter("title") );
		recipe.setInq_content( req.getParameter("content") );

		//작성자id 처리
		Member m = new Member();
		
		m.setUserid((String) req.getSession().getAttribute("userid"));
		
		Member member = new Member();
		
		member.setUserno(memberDao.getUserno(conn, m).getUserno());
		

		if(recipe.getTitle()==null || "".equals(recipe.getTitle())) {
			recipe.setTitle("(제목없음)");
		}

		if( recipeDao.insert(conn, recipe, member) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}

	@Override
	public Recipe getDataByUserno(String userno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		return recipeDao.getDataByUserno(conn, userno);
	}
	
	
	public Recipe getRecipeByUserno(HttpServletRequest req) {

		Connection conn = JDBCTemplate.getConnection();
		
		int userno = Integer.parseInt( req.getParameter("userno") );
		
		return recipeDao.getRecipeByUserno(conn, userno);
	}

	@Override
	public void Updatedata(HttpServletRequest req) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( recipeDao.UpdateRecipe(conn, req) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}

	@Override
	public Recipe getRecipeDataFromReq(HttpServletRequest req) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int postno = Integer.parseInt(req.getParameter("postno"));
		
		return recipeDao.getRecipeDataFromReq(conn, postno);
	}

	@Override
	public void deleteRecipe(HttpServletRequest req) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( recipeDao.deleteRecipe(conn, req) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
		
	}



}
