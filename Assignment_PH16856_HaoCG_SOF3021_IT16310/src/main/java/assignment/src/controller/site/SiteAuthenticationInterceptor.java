package assignment.src.controller.site;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SiteAuthenticationInterceptor implements HandlerInterceptor{
	@Autowired
	private HttpSession session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(session.getAttribute("account") != null) {
			return true;
		}
		
		session.setAttribute("redirect-uri", request.getRequestURI());
		response.sendRedirect("/home/index");
		return false;
	}	
}
