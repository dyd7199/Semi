package service.face;

import dto.Restaurant;

public interface RestaurantService {

	/**
	 *  top 5 식당 조회
	 * @return
	 */
	public Restaurant getTopRest();

}
