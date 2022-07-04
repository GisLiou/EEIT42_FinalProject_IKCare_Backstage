package tw.com.finalproj.dao;

import tw.com.finalproj.service.domain.FoodDataBean;

public interface FoodDataDAO {
	public abstract FoodDataBean select(Integer sampleid);

}