package ptithcm.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Truoc khi vao controller");
		if(UserLogin.tenDangNhap.equals("none")) { // cái   userlogin  cái class có static đó á nha ok
			response.sendRedirect(request.getContextPath() + "/dangnhap.htm");// trong "" là link nếu kh hợp lệ
			return false;
		} 
		//response.sendRedirect(request.getContextPath() + "/Lesson6/index.htm");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Sau khi post controller");
		
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Sau khi thuc hien xong controller");
	}
	
}
