package himedia.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
	
	protected String dbuser = null;
	protected String dbpass = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext context = getServletContext();
		dbuser = context.getInitParameter("dbuser");
		dbuser = context.getInitParameter("dbpass");
	}
	
	

}
