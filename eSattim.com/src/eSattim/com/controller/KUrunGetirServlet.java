package eSattim.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSattim.com.dao.UrunDao;
import eSattim.com.model.UrunBean;


@WebServlet("/kurunget")
public class KUrunGetirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int katagoriNo = Integer.parseInt(request.getParameter("katagoriNo"));
		if (katagoriNo != 0) {
			ArrayList<UrunBean> urunler = UrunDao.KUrunler(katagoriNo);
			request.setAttribute("katagoriUrun", urunler);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
