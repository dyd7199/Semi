package detail.service.face;

import javax.servlet.http.HttpServletRequest;

import review.dto.Seoul;

public interface DetailService {

	/**업소번호 받아오기
	 * 
	 * @param req
	 * @return
	 */
	Seoul getupsono(HttpServletRequest req);

	/**업소번호로 선택된 업소 정보 보기
	 * 
	 * @param upso_sno
	 * @return
	 */
	Seoul view(Seoul upso_sno);

}
