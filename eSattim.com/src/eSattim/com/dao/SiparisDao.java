package eSattim.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import eSattim.com.model.SiparisBean;

public class SiparisDao {
	public static void main(String args[]) {
		siparisGuncelle(9017, "sipsipsip");
	}

	public static void siparisEkle(int urunid, String urunad, int musteriid, String musteriad, String musteriemail,
			String kargo, String adres, int taksitsay) {
		SiparisBean siparis = new SiparisBean();
		siparis.setURUN_ID(urunid);
		siparis.setURUN_AD(urunad);
		siparis.setMUSTERI_ID(musteriid);
		siparis.setMUSTERI_AD(musteriad);
		siparis.setMUSTERI_EMAIL(musteriemail);
		siparis.setKARGO_TERCIH(kargo);
		siparis.setADRES(adres);
		siparis.setTAKSIT_SAY(taksitsay);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "INSERT INTO ORDER_TBL (SIPARIS_ID,URUN_ID,URUN_AD,MUSTERI_ID,MUSTERI_AD,MUSTERI_EMAIL,SIPARIS_DURUM,KARGO_TERCIH,ADRES,TAKSIT_SAY) "
					+ "values (ORDER_TBL_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sorgu);
			ps.setInt(1, urunid);
			ps.setString(2, urunad);
			ps.setInt(3, musteriid);
			ps.setString(4, musteriad);
			ps.setString(5, musteriemail);
			ps.setString(6, "Siparis Verildi");
			ps.setString(7, kargo);
			ps.setString(8, adres);
			ps.setInt(9, taksitsay);
			int row = ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Veritabanına bağlantı sağlanamadı!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int siparisSayisi() {
		int sayi = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT COUNT(*) FROM ORDER_TBL";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			ResultSet rs = psmt.executeQuery(sorgu);

			while (rs.next()) {
				sayi = rs.getInt(1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sayi;
	}

	public static ArrayList<SiparisBean> SIDSiparis(int id) {
		ArrayList<SiparisBean> spr = new ArrayList<SiparisBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM ORDER_TBL WHERE SIPARIS_ID =?";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				SiparisBean siparis = new SiparisBean();
				siparis.setSIPARIS_ID(rs.getInt("SIPARIS_ID"));
				siparis.setURUN_ID(rs.getInt("URUN_ID"));
				siparis.setURUN_AD(rs.getString("URUN_AD"));
				siparis.setMUSTERI_ID(rs.getInt("MUSTERI_ID"));
				siparis.setMUSTERI_AD(rs.getString("MUSTERI_AD"));
				siparis.setMUSTERI_EMAIL(rs.getString("MUSTERI_EMAIL"));
				siparis.setSIPARIS_DURUM(rs.getString("SIPARIS_DURUM"));
				siparis.setKARGO_TERCIH(rs.getString("KARGO_TERCIH"));
				siparis.setADRES(rs.getString("ADRES"));
				siparis.setTAKSIT_SAY(rs.getInt("TAKSIT_SAY"));

				spr.add(siparis);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return spr;
	}

	public static ArrayList<SiparisBean> UIDSiparis(int id) {
		ArrayList<SiparisBean> spr = new ArrayList<SiparisBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM ORDER_TBL WHERE MUSTERI_ID = ?";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				SiparisBean siparis = new SiparisBean();
				siparis.setSIPARIS_ID(rs.getInt("SIPARIS_ID"));
				siparis.setURUN_ID(rs.getInt("URUN_ID"));
				siparis.setURUN_AD(rs.getString("URUN_AD"));
				siparis.setMUSTERI_ID(rs.getInt("MUSTERI_ID"));
				siparis.setMUSTERI_AD(rs.getString("MUSTERI_AD"));
				siparis.setMUSTERI_EMAIL(rs.getString("MUSTERI_EMAIL"));
				siparis.setSIPARIS_DURUM(rs.getString("SIPARIS_DURUM"));
				siparis.setKARGO_TERCIH(rs.getString("KARGO_TERCIH"));
				siparis.setADRES(rs.getString("ADRES"));
				siparis.setTAKSIT_SAY(rs.getInt("TAKSIT_SAY"));
				spr.add(siparis);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return spr;
	}

	public static ArrayList<SiparisBean> AllOrder() {
		ArrayList<SiparisBean> spr = new ArrayList<SiparisBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM ORDER_TBL";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				SiparisBean siparis = new SiparisBean();
				siparis.setSIPARIS_ID(rs.getInt("SIPARIS_ID"));
				siparis.setURUN_ID(rs.getInt("URUN_ID"));
				siparis.setURUN_AD(rs.getString("URUN_AD"));
				siparis.setMUSTERI_ID(rs.getInt("MUSTERI_ID"));
				siparis.setMUSTERI_AD(rs.getString("MUSTERI_AD"));
				siparis.setMUSTERI_EMAIL(rs.getString("MUSTERI_EMAIL"));
				siparis.setSIPARIS_DURUM(rs.getString("SIPARIS_DURUM"));
				siparis.setKARGO_TERCIH(rs.getString("KARGO_TERCIH"));
				siparis.setADRES(rs.getString("ADRES"));
				siparis.setTAKSIT_SAY(rs.getInt("TAKSIT_SAY"));
				spr.add(siparis);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return spr;
	}

	public static int siparisSil(int id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "DELETE FROM ORDER_TBL WHERE SIPARIS_ID =?";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setInt(1, id);
			return psmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public static int siparisGuncelle(int id ,String durum) {
		Connection con = null;
		final String OJDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
		final String DB_URL = "jdbc:oracle:thin:@localhost:1521/xe";
		final String User = "onur";
		final String Password = "1234Onur.";
		try {
			try {
				Class.forName(OJDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = (Connection) DriverManager.getConnection(DB_URL, User, Password);
			String query = "UPDATE ORDER_TBL SET SIPARIS_DURUM=? WHERE SIPARIS_ID=?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, durum);
			stm.setInt(2, id);
			return stm.executeUpdate();
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return 0;
	}
	

}
