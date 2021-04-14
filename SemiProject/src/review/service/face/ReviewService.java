package review.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import review.dto.Review;
import review.util.Paging;

public interface ReviewService {

	Paging getPaging(HttpServletRequest req);

	List<Review> getList(Paging paging);

	Review getReviewno(HttpServletRequest req);

	Review view(Review reviewno);

	void write(HttpServletRequest req);

	void delete(Review review);

}
