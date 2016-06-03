package eSattim.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSattim.com.dao.KategoriDao;

/**
 * Servlet implementation class KtgAdGetir
 */
@WebServlet("/ktgGtr")
public class KtgAdGetir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int ktgID = Integer.parseInt(request.getParameter("ktgAd"));
		String ktgAd = KategoriDao.getKtgAd(ktgID);
		response.getWriter().println(ktgAd);
	}
}
