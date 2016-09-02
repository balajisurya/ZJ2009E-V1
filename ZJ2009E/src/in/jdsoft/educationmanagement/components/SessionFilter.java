package in.jdsoft.educationmanagement.components;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter
public class SessionFilter implements  Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { 
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
    ServletException {
 //   System.out.println("filter called");
    final HttpServletRequest req = (HttpServletRequest) request;
    final HttpSession session = req.getSession(false);
    if (session != null && !session.isNew()) {
        chain.doFilter(request, response);
    } else {
   //     System.out.println("Has timed out");
       req.getRequestDispatcher("/").forward(request, response);
   
    }
    	
}

@Override
public void destroy() {
}
}