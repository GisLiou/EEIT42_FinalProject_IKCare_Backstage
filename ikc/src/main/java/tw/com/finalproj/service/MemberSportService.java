package tw.com.finalproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.MemberSportDAO;
import tw.com.finalproj.service.domain.MemberSportBean;

@Service
@Transactional
public class MemberSportService {
	@Autowired
	private MemberSportDAO memberSportDAO;

	public List<MemberSportBean> select(MemberSportBean bean) {
		List<MemberSportBean> result = null;
		if (bean != null && bean.getUseraccount() != null) {
			MemberSportBean temp = memberSportDAO.select(bean.getSportid());
			if (temp != null) {
				result = new ArrayList<MemberSportBean>();
				result.add(temp);
			}
		} else {
			result = memberSportDAO.select();
		}
		return result;
	}
	
	public List<MemberSportBean> selectaccount(String useraccount) {
		List<MemberSportBean> result = null;
		if (useraccount != null && useraccount.length() != 0) {
			result = memberSportDAO.selectaccount(useraccount);
		}
		return result;
	}
}
