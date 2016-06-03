package eSattim.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSattim.com.dao.RegisterDao;
import eSattim.com.model.RegisterBean;
import eSattim.com.model.UrunBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("emaillog");
		String sifre = request.getParameter("sifrelog");
		if (RegisterDao.kullaniciVarmi(email, sifre) == true) {
			if (RegisterDao.userControl(email) == true) {
				RegisterBean admin = new RegisterBean();
				admin.setUSER_ID(RegisterDao.getUserId(email));
				admin.setUSER_AD(RegisterDao.getUserName(email));
				request.getSession().setAttribute("admin", admin);
				response.sendRedirect("admin.jsp");
			} else {
				ArrayList<UrunBean> sepet = new ArrayList<UrunBean>();
				String message = "";
				request.getSession().setAttribute("sepet", sepet);

				RegisterBean alici = new RegisterBean();
				alici.setUSER_ID(RegisterDao.getUserId(email));
				alici.setUSER_AD(RegisterDao.getUserName(email));
				alici.setUSER_SOYAD(RegisterDao.getUserSurname(email));
				alici.setUSER_EMAIL(email);
				alici.setUSER_PASS(RegisterDao.getUserPass(email));
				alici.setUSER_GSM(RegisterDao.getUserGsm(email));
				request.getSession().setAttribute("alici", alici);
				response.sendRedirect("home.jsp");
			}
		} else {
			response.sendRedirect("failLog.jsp");
		}
	}

}
