package tw.com.finalproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.finalproj.service.domain.FoodDataBean;

public interface FoodDataRepositor extends JpaRepository<FoodDataBean, Integer> {

}
