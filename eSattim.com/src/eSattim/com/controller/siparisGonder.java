package eSattim.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eSattim.com.dao.SiparisDao;
import eSattim.com.model.RegisterBean;
import eSattim.com.model.SiparisBean;
import eSattim.com.model.UrunBean;


/**
 * Servlet implementation class siparisGonder
 */
@WebServlet("/siparisGonder")
public class siparisGonder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public siparisGonder() {
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
		int taksit = Integer.parseInt(request.getParameter("taksit"));
		String kargo = request.getParameter("kargo");
		String adres = request.getParameter("adres");
		
		RegisterBean musteri = (RegisterBean) request.getSession().getAttribute("alici");
		ArrayList<UrunBean> musteriUrun = (ArrayList<UrunBean>) request.getSession().getAttribute("sepet");
		
		try {
			for (UrunBean urun : musteriUrun) {
				SiparisBean yeniSiparis = new SiparisBean();
				yeniSiparis.setURUN_ID(urun.getUrunid());
				int urunid = urun.getUrunid();
				yeniSiparis.setURUN_AD(urun.getUrunad());
				String urunad = urun.getUrunad();
				yeniSiparis.setMUSTERI_ID(musteri.getUSER_ID());
				int musteriid = musteri.getUSER_ID();
				yeniSiparis.setMUSTERI_AD(musteri.getUSER_AD());
				String musteriad = musteri.getUSER_AD(); 
				yeniSiparis.setMUSTERI_EMAIL(musteri.getUSER_EMAIL());
				String musteriemail = musteri.getUSER_EMAIL();
				yeniSiparis.setTAKSIT_SAY(taksit);
				yeniSiparis.setKARGO_TERCIH(kargo);
				yeniSiparis.setADRES(adres);
				SiparisDao.siparisEkle(urunid, urunad, musteriid, musteriad, musteriemail, kargo, adres, taksit);
			}
			musteriUrun.clear();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		response.sendRedirect("home.jsp");
	}
	

}
