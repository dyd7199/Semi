package review.dao.face;

import java.sql.Connection;
import java.util.List;

import review.dto.BoardFile;
import review.dto.Review;
import review.util.Paging;

public interface ReviewDao {

	public int selectCntAll(Connection conn);

	public List<Review> selectAll(Connection conn, Paging paging);

	public Review selectReviewByReviewno(Connection conn, Review reviewno);

	public int insert(Connection conn, Review review);

	public int delete(Connection conn, Review review);

	public int update(Connection conn, Review review);

	public int selectReviewno(Connection conn);

	public int insertFile(Connection conn, BoardFile boardFile);

	public BoardFile selectFile(Connection connection, Review viewReview);


	
}
