package eSattim.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eSattim.com.dao.UrunDao;

/**
 * Servlet implementation class ResimGetir
 */
@WebServlet("/resimGetir")
public class ResimGetir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resimID = Integer.parseInt(request.getParameter("mresim"));
		response.setContentType("image/jpeg");
		byte[] image = UrunDao.getImageByUrunId(resimID);
		response.setContentLength(image.length);
		response.getOutputStream().write(image);
	}

}
