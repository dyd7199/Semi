package service.face;

import javax.servlet.http.HttpServletRequest;

import dto.Seoul;

public interface DetailService {

	/**업소번호 가져오기
	 * 
	 * @param req
	 * @return upso_sno
	 */
	Seoul getupso_sno(HttpServletRequest req);

	/**업소의 상세정보 가져오기
	 * 
	 * @param upso_sno
	 * @return
	 */
	Seoul view(Seoul upso_sno);

	/**
	 * 글 작성시 업소번호 가져오기
	 * @param req
	 * @return
	 */
	Seoul writegetupso_sno(HttpServletRequest req);

}
