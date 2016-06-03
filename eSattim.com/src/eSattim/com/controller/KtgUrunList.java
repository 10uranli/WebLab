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

/**
 * Servlet implementation class KtgUrunList
 */
@WebServlet("/ktgUrunList")
public class KtgUrunList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KtgUrunList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ktgad = request.getParameter("ktgsec");
		int id = UrunDao.idBul(ktgad);
		ArrayList<UrunBean> urun = UrunDao.KategoriUrunler(id);
		request.getSession().setAttribute("urun", urun);
		request.getRequestDispatcher("searchkategori.jsp").forward(request, response);
	}
}