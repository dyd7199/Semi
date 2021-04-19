package service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import dao.face.FileDao;
import dao.impl.FileDaoImpl;
import dto.AttachmentsFile;
import dto.UploadFile;
import service.face.FileService;

public class FileServiceImpl implements FileService {

	//DAO 객체
	private FileDao fileDao = new FileDaoImpl();
	
	@Override
	public void fileupload(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("FileService - fileupload() 호출");
		//-----------------------------------------------------------------

		//응답객체 설정하기
		resp.setContentType("text/html; charset=UTF-8");
		
		//응답 출력 스트림 얻기
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//-----------------------------------------------------------------
		
		//1. 파일업로드 형태의 데이터가 맞는지 검사
		//	-> 요청메시지(request)의 content-type이 multipart/form-data인지
		//	 확인하는 작업
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//1-1. multipart/form-data가 아니면 처리 중단시키기
		if( !isMultipart ) {
			
			out.append("<h1>enctype이 multipart/form-data가 아닙니다</h1>");
			out.append("<a href='/commons/fileupload'>업로드페이지로 이동하기</a>");
			
			//fileupload()메소드 중단시키기
			return;
		}
	
		//1-2. multipart/form-data로 전송되었을 경우
		//	-> 여기 이후로 작성된 부분은 파일업로드 처리를 하는 코드
		
		//-----------------------------------------------------------------
		
		//2. 업로드될 파일을 처리하는 아이템팩토리 객체 생성
		
		//	FileItem
		//		클라이언트에서 전송된 데이터를 객체로 만든 것
		//		폼필드(input태그 데이터), 파일 전부를 뜻함
		
		//	FileItemFactory
		//		업로드된 데이터(FileItem)를 처리하는 방식을 설정하는 클래스
		
		//	DiskFileItemFactory
		//		디스크(HDD)기반으로 파일아이템을 처리하는 클래스
		//		업로드된 파일을 디스크에 임시 저장할 수 있도록 되어있다
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//-----------------------------------------------------------------
		
		//3. 업로드된 파일아이템의 용량이 설정값보다 작으면 메모리에서 처리
		int maxMem = 1 * 1024 * 1024; //1MB
		factory.setSizeThreshold(maxMem);
		
		//-----------------------------------------------------------------

		//4. 용량이 설정보다 크면 임시파일(HDD)을 만들어서 처리
		//	-> 임시파일을 저장할 폴더를 설정할 수 있다
		
		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();
		
		//서버가 배포된(설치된) 폴더의 실제 경로의 tmp폴더를 나타낸다
		String path = context.getRealPath("tmp");
		
		//확인
		System.out.println(path);
		
		//임시 저장 폴더 File객체
		File respository = new File(path);
		
		//임시 폴더 생성
		respository.mkdir();
		
		//임시파일 저장하는 폴더를 factory객체에 설정하기 
		factory.setRepository(respository);
		
		//-----------------------------------------------------------------
		
		//5. 파일업로드 수행객체 생성
		//	-> 업로드된 파일이 허용 용량을 넘으면 업로드되지않도록 설정
		
		//최대 업로드 허용 사이즈
		int maxFile = 10 * 1024 * 1024; //10MB
		
		//파일업로드를 수행하는 객체 생성
		//	-> DiskFileItemFactory객체에 저장한 설정을 이용한다
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//파일 업로드 용량제한 사이즈 설정 : 10MB
		upload.setFileSizeMax(maxFile);
		
		//-----------------------------------------------------------------
		
		//----- 파일 업로드 준비 완료 -----
		
		//-----------------------------------------------------------------
		
		//6. 업로드된 데이터를 추출(파싱)
		//	-> 임시 파일 업로드도 같이 수행된다
		
		List<FileItem> items = null;
		
		try {
			// 요청객체(req)에 담겨있는 전달파라미터(multipart)들을
			//파싱한다
			//	-> 파일업로드도 같이 수행됨
			items = upload.parseRequest( req );
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//-----------------------------------------------------------------
		
		//7. 파싱된 전달파라미터 데이터를 처리하기
		//	-> List<FileItem> 객체에 파일과 폼필드가 파싱되어 들어있음
		
		//	요청정보의 3가지 고려할 형태
		//		1) 빈 파일(용량이 0인 파일)
		//		2) form-data(폼필드, 전달파라미터)
		//		3) 파일
		
		
		//파일아이템 반복자
		Iterator<FileItem> iter = items.iterator();
		
		
		//폼필드를 저장할 DTO 객체 생성
		AttachmentsFile attach = new AttachmentsFile();
		
		//파일이름을 저장할 DTO 객체 생성
		UploadFile uploadFile = new UploadFile();
		
		
		//모든 요청정보를 처리하는 반복문
		while(iter.hasNext()) {
			
			//요청정보를 하나씩 객체로 저장
			FileItem item = iter.next();
			
			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) {
				continue; //빈 파일은 무시하고 다음 FileItem으로 넘김
			}
			
			
			//--- 2) form-data에 대한 처리 ---
			if( item.isFormField() ) {
				
				//--- 전달 파라미터 처리 방법 ---
				// FormField(form-data)는 key=value 쌍으로 전달된다
				
				// key는 item.getFiledName() 메소드로 얻어온다
				// value는 item.getString() 메소드로 얻어온다
				
				//** req.setCharacterEncoding("UTF-8"); 코드가 적용되지 않음
				//	-> req.getParameter("key"); 에 적용되는 코드
				
				//** item.getString("UTF-8"); 로 사용해야 한글 인코딩이
				//	적용된다
				
				//-------------------------------
				
				
				
				//--- 기본 처리 방식 ---
//				out.println("- - - 폼 필드 - - -<br>");
//				out.println(" 키 : " + item.getFieldName() + "<br>");
//				try {
//					out.println(" 값 : " + item.getString("UTF-8") + "<br>");
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
				//----------------------
				
				
				
				//--- 키값에 따른 처리 방식 ---
				// -> 최종 결과를 DTO객체에 저장한다
				
				//키 추출
				String key = item.getFieldName();
				
				try {
					if( "userno".equals( key ) ) {//전달파라미터가 "title"일 때
						AttachmentsFile.setUserno( Integer.parseInt( (Object) req.getSession().getAttribute("userno") ) );
						
					} else if( "data1".equals( key ) ) {//전달파라미터가 "data1"일 때
						AttachmentsFile.setData1( item.getString("UTF-8") );
						
					} else if( "data2".equals( key ) ) {//전달파라미터가 "data2"일 때
						AttachmentsFile.setData2( item.getString("UTF-8") );
						
					} 
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				//-----------------------------

			} //if( item.isFormField() ) end
			
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
				
				//--- 업로드된 파일 처리(보관)하는 방법 ---
				//1. 파일을 웹서버의 로컬디스크(HDD)에 저장한다
				//	-> 파일의 정보를 DB에 기록한다
				//	-> 파일의 저장위치를 DB에 남겨놓는다
				
				//2. 테이블의 컬럼으로 파일의 내용을 저장한다
				//	-> BLOB타입의 컬럼을 만들어 사용한다
				
				//	** 우리는 1번 방식을 사용할 예정
				//-----------------------------------------
				
				
				
				//--- 업로드된 파일의 이름을 시간을 이용해서 변경하기 ---
				//	-> 업로드된 파일이 저장될 때 중복이름이 생기지 않도록
				//	 시간을 이용해서 조절한다
				
				//파일	-> HDD에 저장
				//DB	-> 파일의 저장기록을 남겨놓는다
				//	(원본의 이름, 업로드되어 바뀐 이름)
				
				//서버에 저장되는 이름을 "년월일시분초밀리초.확장자"로 변경
				
				
				
				//시간을 이용한 파일명 만들기
				//	java.util.Date -> String 변환 - SimpleDateFormat 클래스
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date());
				
				
				//확장자는 원본파일 확장자 얻어오기
				String origin = item.getName(); //원본파일 이름
				int dotIdx = origin.lastIndexOf(".");//가장 마지막 "."의 인덱스
				
				//확장자
				String ext = origin.substring(dotIdx + 1);
				
				//서버에 저장될 파일의 이름
				String stored = rename + "." + ext;
				
				System.out.println("[TEST] 원본 파일명 : " + origin);
				System.out.println("[TEST] 저장될 파일명 : " + stored);
				
				//업로드된 파일의 정보를 DTO에 저장하기
				uploadFile.setOriginName(origin);
				uploadFile.setStoredName(stored);				
				//-------------------------------------------------------
				
				
				//--- 업로드된 임시파일을 실제로 저장하기 ---
				//	-> 1MB이하 파일 : 메모리에 임시파일로 업로드
				//	-> 1MB이상 파일 : HDD에 임시파일로 업로드
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir(); //폴더 생성
				
				//실제로 저장될 파일
				File up = new File(uploadFolder, stored);
				
				try {
					item.write( up ); //실제 업로드(최종 결과 파일이 생성됨)
					item.delete(); //임시 파일 삭제
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} //if( !item.isFormField() ) end
			
		} //while(iter.hasNext()) end

		
		
		//[테스트] 폼필드 저장한 DTO
		System.out.println("param - " + paramData);

		//[테스트] 파일 이름 저장한 DTO
		System.out.println("file - " + uploadFile);

		
		
		//--- DB에 최종 데이터 삽입하기 ---
		Connection conn = JDBCTemplate.getConnection();
		
		int res = 0;
		
		//파라미터 데이터 삽입
		res = fileDao.insertParam(conn, paramData);
		if( res >=0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//파일 데이터 삽입
		res = fileDao.insertFile(conn, uploadFile);
		if( res >=0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//---------------------------------
		
	} //fileupload() end

}
