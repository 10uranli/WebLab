package eSattim.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSattim.com.dao.UrunDao;
import eSattim.com.model.RegisterBean;
import eSattim.com.model.UrunBean;

@WebServlet("/sepetekle")
public class SepeteUrunEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("urunID"));
		@SuppressWarnings("unchecked")
		ArrayList<UrunBean> se = (ArrayList<UrunBean>) request.getSession().getAttribute("sepet");
		se.add(UrunDao.tekUrun(id));
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}
}
