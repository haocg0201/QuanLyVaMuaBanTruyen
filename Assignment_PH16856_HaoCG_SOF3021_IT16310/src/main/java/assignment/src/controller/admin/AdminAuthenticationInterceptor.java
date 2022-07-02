package assignment.src.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import assignment.src.model.entity.Account;

@Component
public class AdminAuthenticationInterceptor implements HandlerInterceptor{
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(session.getAttribute("account") != null ) {
			Account account = (Account) session.getAttribute("account");
			if(account.isRole()) {
				return true;
			}	
		}
		
		session.setAttribute("redirect-uri", request.getRequestURI());
		response.sendRedirect("/signin");
		
		return false; // không tiếp tục thực hiện các địa chỉ hay các action được yêu cầu từ phái client và chuyển hướng đến trang đăng nhập
	}
	
	
}
