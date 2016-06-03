package eSattim.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eSattim.com.dao.SiparisDao;
import eSattim.com.dao.UrunDao;
import eSattim.com.model.SiparisBean;
import eSattim.com.model.UrunBean;

/**
 * Servlet implementation class SiparisAraServlet
 */
@WebServlet("/SiparisAraSID")
public class SiparisAraSIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiparisAraSIDServlet() {
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
		HttpSession session= request.getSession(true);
		int id = Integer.parseInt(request.getParameter("siparisId"));
		ArrayList<SiparisBean> spr = SiparisDao.SIDSiparis(id);
		session.setAttribute("spr",spr);
		response.sendRedirect("resultsiparis.jsp");
		
	}

}
