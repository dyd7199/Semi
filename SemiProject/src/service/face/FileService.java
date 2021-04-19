package service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {

	/**
	 * 파일업로드받아 처리하는 객체
	 * 
	 * @param req
	 * @param resp
	 */
	void fileupload(HttpServletRequest req, HttpServletResponse resp);

}
