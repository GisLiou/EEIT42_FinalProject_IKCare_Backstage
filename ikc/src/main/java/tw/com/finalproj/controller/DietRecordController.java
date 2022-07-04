package tw.com.finalproj.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.finalproj.service.MembersService;

@Controller
public class DietRecordController {

	@Autowired
	MembersService membersService;
	
	public void init(WebDataBinder webDataBinder) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor1 = new CustomDateEditor(sFormat, true);
		webDataBinder.registerCustomEditor(java.util.Date.class, editor1);
	}
	
	@RequestMapping(path = {""})
	public String SearchFoodData(Model model,String foodname) {
		//接收資料
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		
		return"";
		
	}
}
