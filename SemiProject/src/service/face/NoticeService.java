package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.Notice;

public interface NoticeService {

	/**
	 * 공지사항 리스트 전체 조회.
	 * 
	 * @return 공지사항 전체 조회 결과 리스트.
	 */
	public List<Notice> getList();
	
	/**
	 * 요청파라미터 얻기  
	 *
	 * @param 요청정보 객체   
	 * @return Notice 전달파라미터 postno를 포함한 객체   
	 */
	public Notice getPostno(HttpServletRequest req);

	/**
	 * 주어진 postno를 이용하여 상세페이지를 조회한다  
	 * 조회된 게시글의 조회수를 증가시킨다  
	 * 
	 * @param postno
	 * @return
	 */
	public Notice view(int post);
	
	


	

	

	
	
}
