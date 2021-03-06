package tw.com.finalproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.SleepingDAO;
import tw.com.finalproj.service.domain.SleepingBean;

@Service
@Transactional
public class SleepingService {
	@Autowired
	private SleepingDAO sleepingDAO;

	public List<SleepingBean> select(SleepingBean bean) {
		List<SleepingBean> result = null;
		if (bean != null && bean.getUseraccount() != null) {
			SleepingBean temp = sleepingDAO.select(bean.getSleepingid());
			if (temp != null) {
				result = new ArrayList<SleepingBean>();
				result.add(temp);
			}
		} else {
			result = sleepingDAO.select();
		}
		return result;
	}
	
	public List<SleepingBean> selectaccount(String useraccount) {
		List<SleepingBean> result = null;
		if (useraccount != null && useraccount.length() != 0) {
			result = sleepingDAO.selectaccount(useraccount);
		}
		return result;
	}
}
