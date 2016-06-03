package eSattim.com.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import eSattim.com.dao.UrunDao;

/**
 * Servlet implementation class UrunEkleServlet
 */
@WebServlet("/UEkleServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UrunEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrunEkleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ktgname = request.getParameter("ktgsec");
		String uname = request.getParameter("urunname");
		String ufiyatS = request.getParameter("urunfiyat");
		String uacik = request.getParameter("urunaciklama");
		String uanahtar = request.getParameter("urunanahtar");
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        
		UrunDao urun = new UrunDao();
		int ktgid = urun.idBul(ktgname);
		int ufiyat = Integer.parseInt(ufiyatS);
		
		UrunDao.urunEkle(uname, uacik, ufiyat, ktgid, uanahtar,inputStream);
		response.sendRedirect("product.jsp");
		
		
	}

}
