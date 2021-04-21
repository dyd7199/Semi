package review.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dto.Member;
import review.common.JDBCTemplate;
import review.dao.face.ReviewDao;
import review.dao.impl.ReviewDaoImpl;
import review.dto.BoardFile;
import review.dto.Review;
import review.dto.Seoul;
import review.service.face.ReviewService;
import review.util.Paging;


public class ReviewServiceImpl implements ReviewService {
	private ReviewDao reviewDao = new ReviewDaoImpl();
		
	@Override
	public Paging getPaging(HttpServletRequest req) {
//		System.out.println("getPaging() 호출");
		//전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
		curPage = Integer.parseInt(param);
				}
		//Review 테이블의 총 게시글 수를 조회한다
		int totalCount = reviewDao.selectCntAll(JDBCTemplate.getConnection());
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
				
		return paging;
	}

	@Override
	public List<Review> getList(Paging paging, Seoul upso_sno) {
		return reviewDao.selectAll(JDBCTemplate.getConnection(), paging, upso_sno);
	}

	@Override
	public Review getReviewno(HttpServletRequest req) {
		//reviewno를 저장할 객체 생성
		Review reviewno = new Review();
		//reviewno 전달파라미터 검증 - null, ""
		String param = req.getParameter("reviewno");
		if(param!=null && !"".equals(param)) {
			
			reviewno.setReviewno(Integer.parseInt(param));
		}
		return reviewno;
	}

	@Override
	public Review view(Review reviewno) {
		Connection conn = JDBCTemplate.getConnection();
		
		Review review = reviewDao.selectReviewByReviewno(conn, reviewno); 
		
		return review;
	}

	@Override
	public void write(HttpServletRequest req, Member member, Seoul upso_sno) {
				//게시글 정보 저장할 객체
				Review review = null;
				
				//첨부파일 정보 저장할 객체
				BoardFile boardFile = null;
				
				//파일업로드 형태의 데이터가 맞는지 검사
				boolean isMultipart = false;
				isMultipart = ServletFileUpload.isMultipartContent(req);
				
				//multipart/form-data 인코딩으로 전송되지 않았을 경우
				if( !isMultipart ) {
					System.out.println("[ERROR] multipart/form-data 형식이 아님");
					
					return; //fileupload() 메소드 실행 중지
				}
				
				//게시글 정보 저장할 객체 생성
				review = new Review();
			
				//디스트기반 아이템 팩토리
				DiskFileItemFactory factory = new DiskFileItemFactory();

				//메모리 처리 사이즈 지정
				factory.setSizeThreshold( 1 * 1024 * 1024 ); //1MB
				
				
				//임시 저장소 설정
				File repository = new File(req.getServletContext().getRealPath("tmp"));
				repository.mkdir();
				
				factory.setRepository(repository);
				
				//파일업로드 객체 생성
				ServletFileUpload upload = new ServletFileUpload(factory);

				//업로드 용량 제한
				upload.setFileSizeMax( 10*1024*1024 ); //10MB
				
				//전달 데이터 파싱
				List<FileItem> items = null;
				try {
					items = upload.parseRequest(req);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				
				//추출된 전달파라미터 처리 반복자
				Iterator<FileItem> iter = items.iterator();

				//모든 요청 정보 처리하기
				while( iter.hasNext() ) {
					FileItem item = iter.next();
					
					// 1) 빈 파일 처리
					if( item.getSize() <= 0 )	continue;
					
					// 2) 일반적인 요청 데이터 처리
					if( item.isFormField() ) {

						String key = item.getFieldName(); //키 추출
						if( "title".equals(key) ) { //전달파라미터 name이 "title"
							try {
								review.setTitle( item.getString("UTF-8") );
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
							
						} else if ( "inq_content".equals(key) ) { //전달파라미터 name이 "content"
							try {
								review.setInq_content( item.getString("UTF-8") );
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
							
						} else if ("star_score".equals(key) ){
							try {
								review.setStar_score( Integer.parseInt(item.getString("UTF-8")) );
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}// key값 비교 if end
						}
						
					} // if( item.isFormField() ) end - 폼필드 확인
					
					//유저번호 받아오기
					review.setUserno(member.getUserno());
					//업소번호 받아오기
					review.setUpso_sno(upso_sno.getUpso_sno());
					
					// 3) 파일 처리
					if( !item.isFormField() ) {
						
						// --- UUID 생성 ---
						UUID uuid = UUID.randomUUID(); //랜덤 UID 생성
						String u = uuid.toString().split("-")[0]; //8자리 uid
						// -----------------
						
						// --- 로컬 저장소의 파일 객체 생성 ---
						File upFolder = new File(req.getServletContext().getRealPath("upload")); // 업로드될 폴더 경로
						upFolder.mkdir();
						File up = new File(
								upFolder
								, item.getName()+"_"+u // 원본파일명_uid
								);
						// ------------------------------------
						
						// --- 첨부파일 정보 객체 ---
						boardFile = new BoardFile(); //객체 생성
						boardFile.setOriginName(item.getName()); //원본파일명
						boardFile.setStoredName(item.getName()+"_"+u); //저장파일명
						boardFile.setFilesize((int)item.getSize());
						// --------------------------
						
						// --- 처리 완료된 파일 업로드 하기 ---
						try {
							item.write(up); //실제 업로드
							item.delete(); //임시 파일 삭제
						} catch (Exception e) {
							e.printStackTrace();
						}
						// -----------------------------------
						
					} // 파일 처리 end
					
				} // while( iter.hasNext() ) end - FileItem 반복 처리
				
				
				//DB데이터 입력
				Connection conn = JDBCTemplate.getConnection();
				
				//게시글 번호 생성 - Dao 이용
				int reviewno = reviewDao.selectReviewno(conn);
				
				//게시글 정보가 있을 경우
				if(review != null) {
					
					//게시글 번호 입력
					review.setReviewno(reviewno);
					
					//게시글 삽입
					if( reviewDao.insert(conn, review) > 0 ) {
						JDBCTemplate.commit(conn);
					} else {
						JDBCTemplate.rollback(conn);
					}
				}
				
				//첨부파일 정보가 있을 경우
				if(boardFile != null) {
					//게시글 번호 입력
					boardFile.setBoardno(reviewno);
					
					//첨부파일 삽입
					if( reviewDao.insertFile(conn, boardFile) > 0 ) {
						JDBCTemplate.commit(conn);
					} else {
						JDBCTemplate.rollback(conn);
					}
				}
				
				System.out.println(review);
			}
	@Override
	public void delete(Review review) {
		Connection conn = JDBCTemplate.getConnection();
			
		
		if( reviewDao.delete(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}

	@Override
	public void update(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Review review = new Review();

		review.setReviewno( Integer.parseInt(req.getParameter("boardno")) );
		review.setTitle( req.getParameter("title") );
		review.setInq_content( req.getParameter("inq_content") );
//		System.out.println("review.getTitle()"+review.getTitle());
//		System.out.println("review.getInq_content()"+review.getInq_content());
		
		
//		review.setUserno(req.getParameter("userno"));

		if(review.getTitle()==null || "".equals(review.getTitle())) {
			review.setTitle("(제목없음)");
		}
//System.out.println(review);
		Connection conn = JDBCTemplate.getConnection();
		if( reviewDao.update(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

	@Override
	public BoardFile viewFile(Review viewReview) {
		return reviewDao.selectFile(JDBCTemplate.getConnection(), viewReview);
	
	}


		
	

}
