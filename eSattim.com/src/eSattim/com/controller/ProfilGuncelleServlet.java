package eSattim.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import eSattim.com.dao.RegisterDao;
import eSattim.com.model.RegisterBean;
import eSattim.com.model.UserBean;

/**
 * Servlet implementation class ProfilGuncelleServlet
 */
@WebServlet("/profilGuncelle")
public class ProfilGuncelleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilGuncelleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String ad = request.getParameter("name");
		String soyad = request.getParameter("surname");
		String email = request.getParameter("email");
		String sifre = request.getParameter("pass");
		String tel = request.getParameter("gsm");
		
		RegisterDao.updateUser(ad, soyad, email, sifre, tel, id);
		RegisterBean alici = (RegisterBean)request.getSession().getAttribute("alici");
		alici.setUSER_AD(ad);
		alici.setUSER_SOYAD(soyad);
		alici.setUSER_EMAIL(email);
		alici.setUSER_PASS(sifre);
		alici.setUSER_GSM(tel);
		request.getSession().setAttribute("alici", alici);
		response.sendRedirect("userprofil.jsp");
		
		
	}

}
