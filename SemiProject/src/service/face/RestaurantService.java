package service.face;

import java.util.List;

import review.dto.Seoul;

public interface RestaurantService {

	/**
	 * 탑랭킹 맛집 정보가져오기
	 * @return
	 */
	public List<Seoul> getTopRest();



}
