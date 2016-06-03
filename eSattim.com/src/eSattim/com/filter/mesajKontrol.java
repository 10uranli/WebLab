//package eSattim.com.filter;
//
//import java.io.IOException;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//
//import eSattim.com.model.RegisterBean;
//
//@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
//		DispatcherType.ERROR }, urlPatterns = { "/mesaj.jsp" })
//public class mesajKontrol implements Filter {
//	protected FilterConfig config;
//	protected String filterName;
//	protected ServletContext context;
//
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
//		HttpServletRequest htprq = (HttpServletRequest)request;
//		if ((RegisterBean) htprq.getSession().getAttribute("alici") == null) {
//			request.getRequestDispatcher("loginreg.jsp").forward(request, response);
//		}
//		else{
//			chain.doFilter(request, response);
//		}
//
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		this.config = fConfig;
//		this.context = config.getServletContext();
//		this.filterName = config.getFilterName();
//	}
//
//}
