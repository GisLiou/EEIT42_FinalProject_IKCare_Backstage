package tw.com.finalproj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import tw.com.finalproj.service.MembersService;
import tw.com.finalproj.service.domain.MembersBean;


//@WebServlet(urlPatterns = "/en-us/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MembersService membersService;
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = (ApplicationContext) application
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		membersService  =context.getBean("membersService",MembersService.class);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收資料
		String useraccount = request.getParameter("account");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String Gender = request.getParameter("Gender");
		String temp = request.getParameter("birthday");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		
		HttpSession httpSession = request.getSession();
		//驗證資料
		
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		
		java.util.Date birthday =null;
		
		if(temp != null && temp.length() !=0) {
			try {
				birthday = sFormat.parse(temp);
			} catch (ParseException e) {
				errors.put("birthday", "生日的格式必須是(YYYY-MM-DD)");
			}
		}
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/secure/ec_p3_login.jsp").forward(request,
					response);
			return;
		}
		MembersBean bean = new MembersBean();
		bean.setUseraccount(useraccount);
		bean.setUserpassword(password);
		bean.setMembername(name);
		bean.setBirthday(birthday);
		bean.setAddress(address);
		bean.setTelephone("");
		bean.setCellphone("");
		bean.setEmail(useraccount);
		bean.setUserlevel("一般會員");
		bean.setArea(city);
		bean.setGender(Gender);
		System.out.println(bean);
		
		MembersBean result = membersService.insert(bean);
		System.out.println(result);
		if(result!=null) {
			MembersBean membersbean = membersService.login(useraccount, password);
			httpSession.setAttribute("membersbean", membersbean);
			request.getRequestDispatcher("/secure/ec_p3_login.jsp").forward(request, response);
		}else {
			errors.put("fail", "insert fail");
			request.getRequestDispatcher("/secure/ec_p3_login.jsp").forward(request, response);
		}
	}

}
