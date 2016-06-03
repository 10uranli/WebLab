package eSattim.com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eSattim.com.model.UrunBean;

public class UrunDao {
	public static void main(String[] args) {
	}

	public static void urunEkle(String ad, String aciklama, int fiyat, int kid, String anahtar, InputStream st) {
		UrunBean urun = new UrunBean();
		urun.setKtgid(kid);
		urun.setUaciklama(aciklama);
		urun.setUrunfiyat(fiyat);
		urun.setUrunad(ad);
		urun.setUanahtar(anahtar);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "INSERT INTO URUN_TBL(URUN_ID, URUN_AD ,URUN_ACIKLAMA ,URUN_FIYAT ,KATEGORI_ID ,URUN_ANAHTAR, URUN_RESIM) values (URUN_TBL_SEQ.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sorgu);
			ps.setString(1, ad);
			ps.setString(2, aciklama);
			ps.setInt(3, fiyat);
			ps.setInt(4, kid);
			ps.setString(5, anahtar);
			ps.setBlob(6, st);
			ps.executeQuery();
			System.out.println("Kayıt Başarıyla Eklendi.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Veritabanına bağlantı sağlanamadı!\n" +ex.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<UrunBean> tumUrunler() {
		ArrayList<UrunBean> urunler = new ArrayList<UrunBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM URUN_TBL";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				UrunBean urun = new UrunBean();
				urun.setUrunid(rs.getInt("URUN_ID"));
				urun.setUrunad(rs.getString("URUN_AD"));
				urun.setUrunfiyat(rs.getInt("URUN_FIYAT"));
				urun.setKtgid(rs.getInt("KATEGORI_ID"));
				urunler.add(urun);
				System.out.println(urun.getUrunad());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return urunler;
	}

	public static ArrayList<UrunBean> KategoriUrunler(int id) {
		ArrayList<UrunBean> urunler = new ArrayList<UrunBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM URUN_TBL WHERE KATEGORI_ID=?";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				UrunBean urun = new UrunBean();
				urun.setUrunid(rs.getInt("URUN_ID"));
				urun.setUrunad(rs.getString("URUN_AD"));
				urun.setUrunfiyat(rs.getInt("URUN_FIYAT"));
				urun.setKtgid(rs.getInt("KATEGORI_ID"));
				urunler.add(urun);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return urunler;
	}

	public static ArrayList<UrunBean> KUrunler(int kategoriID) {
		ArrayList<UrunBean> urunler = new ArrayList<UrunBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM URUN_TBL where KATEGORI_ID = ?";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setInt(1, kategoriID);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				UrunBean urun = new UrunBean();
				urun.setUrunid(rs.getInt("URUN_ID"));
				urun.setUrunad(rs.getString("URUN_AD"));
				urun.setUrunfiyat(rs.getInt("URUN_FIYAT"));
				urun.setKtgid(rs.getInt("KATEGORI_ID"));
				urunler.add(urun);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return urunler;
	}

	public static UrunBean tekUrun(int urunID) {
		UrunBean urun = new UrunBean();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM URUN_TBL where URUN_ID = ?";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setInt(1, urunID);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				urun.setUrunid(rs.getInt("URUN_ID"));
				urun.setUrunad(rs.getString("URUN_AD"));
				urun.setKtgAd(KategoriDao.getKtgAd(rs.getInt("KATEGORI_ID")));
				urun.setUrunfiyat(rs.getInt("URUN_FIYAT"));
				urun.setKtgid(rs.getInt("KATEGORI_ID"));
				urun.setUaciklama(rs.getString("URUN_ACIKLAMA"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return urun;
	}

	public static int idBul(String ktgname) {
		int ids = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT KTG_ID FROM KTG_TBL WHERE KTG_AD=" + "'" + ktgname + "'";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				ids = rs.getInt("KTG_ID");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ids;
	}

	public static void DelForKTG(int id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "DELETE FROM URUN_TBL WHERE KATEGORI_ID=?";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setInt(1, id);
			psmt.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<UrunBean> urunArama(String arama) {
		ArrayList<UrunBean> urunler = new ArrayList<UrunBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM URUN_TBL WHERE URUN_AD LIKE '?' OR URUN_ACIKLAMA  LIKE '?' URUN_ANAHTAR LIKE '?'";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setString(1, arama);
			psmt.setString(2, arama);
			psmt.setString(3, arama);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				UrunBean urun = new UrunBean();
				urun.setUrunid(rs.getInt("URUN_ID"));
				urun.setUrunad(rs.getString("URUN_AD"));
				urun.setUrunfiyat(rs.getInt("URUN_FIYAT"));
				urun.setKtgid(rs.getInt("KATEGORI_ID"));
				urunler.add(urun);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return urunler;
	}

	public static void urunSil(int id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "DELETE FROM URUN_TBL WHERE URUN_ID=?";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			psmt.setInt(1, id);
			psmt.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int urunSayisi() {
		int sayi=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT COUNT(*) FROM URUN_TBL";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			ResultSet rs = psmt.executeQuery(sorgu);

			while (rs.next()) {
				sayi= rs.getInt(1);
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sayi;
	}
	
	public static byte[] getImageByUrunId(int urunID){
		String query = "select URUN_RESIM from URUN_TBL where URUN_ID=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String kullaniciad = "onur";
		String sifre = "1234Onur.";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, kullaniciad, sifre);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement psmt;
		byte[] bytesImage = null;
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, urunID);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				bytesImage = rs.getBytes("URUN_RESIM");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bytesImage;
	}

}
