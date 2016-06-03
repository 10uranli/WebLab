package eSattim.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eSattim.com.model.UrunBean;

/**
 * Servlet implementation class SepettenUrunSil
 */
@WebServlet("/sepettenSil")
public class SepettenUrunSil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SepettenUrunSil() {
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
		int id = Integer.parseInt(request.getParameter("urunID"));
		ArrayList<UrunBean> se = (ArrayList<UrunBean>) request.getSession().getAttribute("sepet");
		try {
			se.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("sepet.jsp").forward(request, response);
	}

}
