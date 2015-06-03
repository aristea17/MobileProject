package code;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter{

	private ServletContext context;
	
	public void init(FilterConfig config) throws ServletException {
		context = config.getServletContext();
		this.context.log("LoginFilter initialized");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log(req.getRemoteAddr() + "::Request params::{" + name + "=" + value + "}");
		}
		//pass the request along the filter chain 
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		//close resources here
	}
}	