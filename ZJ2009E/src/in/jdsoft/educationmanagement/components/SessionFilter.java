package in.jdsoft.educationmanagement.components;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		  HttpServletRequest servletRequest=(HttpServletRequest)req;
		  HttpSession session=servletRequest.getSession(false);
		  if(servletRequest.getRequestURI().equals(req.getServletContext().getContextPath())){
			  System.out.println("hello 1");
			  chain.doFilter(req, res);
		  }
		  else{
			  if(session==null){
					System.out.println("hai");
					HttpServletResponse	servletResponse=(HttpServletResponse)res;
					System.out.println(req.getServletContext().getContextPath());
					servletResponse.sendRedirect(req.getServletContext().getContextPath());
				}else{
					  System.out.println("hello 1");
					   chain.doFilter(req, res);
				}
		  }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
