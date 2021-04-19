package dao.face;

import java.sql.Connection;

import dto.ParamData;
import dto.UploadFile;

public interface FileDao {

	/**
	 * 전달파라미터 데이터 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param paramData - 저장할 전달데이터 DTO 객체
	 * @return 삽입 수행 결과값
	 */
	public int insertParam(Connection conn, ParamData paramData);
	
	/**
	 * 파일 정보 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param uploadFile - 파일의 정보 DTO 객체
	 * @return 삽입 수행 결과값
	 */
	public int insertFile(Connection conn, UploadFile uploadFile);

}
