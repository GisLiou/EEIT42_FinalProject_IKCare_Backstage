package tw.com.finalproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
	@RequestMapping(path = {"/"})
	public String handlerMethod1() {
		return "/index";
	}
	@RequestMapping(path = "/secure/ec_p3_login")
	public String handlerMethod2() {
		
		return "/secure/ec_p3_login";
	}
	@RequestMapping(path= {"/pages/dietRecord"})
	public String dietpath() {
		return"/pages/dietRecord";
	}
	@RequestMapping(path= {"/backstage/Index"})
	public String backstagepath() {
		return"/backstage/Index";
	}
	@RequestMapping(path= {"/backstage/pages/MemberControl"})
	public String bsmemberpath() {
		return"/backstage/pages/MemberControl";
	}
	@RequestMapping(path= {"/backstage/pages/Product"})
	public String bsproductpath() {
		return"/backstage/pages/Product";
	}
	@RequestMapping(path= {"/backstage/pages/SuppliesDisplay"})
	public String bssuppliespath() {
		return"/backstage/pages/SuppliesDisplay";
	}
	@RequestMapping(path= {"/backstage/pages/OrdersDisplay"})
	public String bsorderpath() {
		return"/backstage/pages/OrdersDisplay";
	}
	@RequestMapping(path= {"/backstage/pages/MemberInformation"})
	public String bsinfomationpath() {
		return "/backstage/pages/MemberInformation";
	}
}
