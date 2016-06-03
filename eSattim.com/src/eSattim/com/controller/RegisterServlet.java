package eSattim.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSattim.com.dao.RegisterDao;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ad = request.getParameter("isim");
		String soyad = request.getParameter("soyisim");
		String email = request.getParameter("email");
		String sifre = request.getParameter("sifre");
		if(RegisterDao.emailKontrol(email)){
			response.sendRedirect("failRegister.jsp");
		}else{
			RegisterDao.registerUser(ad, soyad, email, sifre);
			response.sendRedirect("loginreg.jsp");
		}
		
		
	}

}
