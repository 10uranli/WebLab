package eSattim.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import eSattim.com.model.KategoriBean;

public class KategoriDao {
	public static void main(String[] args) {
	
	}

	public static ArrayList<KategoriBean> kategoriler() {
		ArrayList<KategoriBean> kategoriler = new ArrayList<KategoriBean>();
		try {
			Connection con = null;
			final String OJDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
			final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
			final String User = "onur";
			final String Password = "1234Onur.";

			Class.forName(OJDBC_DRIVER);
			con = (Connection) DriverManager.getConnection(DB_URL, User, Password);
			Statement statement = con.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM KTG_TBL");
			while (resultset.next()) {
				kategoriler.add(new KategoriBean(resultset.getInt(1), resultset.getString(2)));
			}
		} catch (Exception e) {
		}
		return kategoriler;
	}

	public static void KategoriEkle(String ad) {
		KategoriBean ktg = new KategoriBean();
		ktg.setKtgAd(ad);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "INSERT INTO KTG_TBL (KTG_ID,KTG_AD) values (KTG_TBL_SEQ.NEXTVAL,?)";

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sorgu);
			ps.setString(1, ad);
			int row = ps.executeUpdate();
			System.out.println("Kayıt Başarıyla Eklendi.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Veritabanına bağlantı sağlanamadı!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void KategoriSil(String ad) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "DELETE FROM KTG_TBL WHERE KTG_AD =?";

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sorgu);
			ps.setString(1, ad);
			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Veritabanına bağlantı sağlanamadı!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getKtgId(String ad) {
		int id = 0;
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
			String query = "SELECT KTG_ID FROM KTG_TBL WHERE KTG_AD = ?";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setString(1, ad);
			ResultSet row = statement.executeQuery();
			if (row.next()) {
				id = row.getInt(1);
			} else
				id = 0;
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
		return id;
	}
	
	public static String getKtgAd(int id) {
		String ad = "";
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
			String query = "SELECT KTG_AD FROM KTG_TBL WHERE KTG_ID = ?";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet row = statement.executeQuery();
			if (row.next()) {
				ad = row.getString(1);
			} else
				ad = "";
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
		return ad;
	}
	public static int kategoriSayisi() {
		int sayi=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT COUNT(*) FROM KTG_TBL";
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
	public static boolean kategoriVarmi(String ktgname) {
		Connection conn = null;
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
			conn = (Connection) DriverManager.getConnection(DB_URL, User, Password);
			String query = "SELECT KTG_AD FROM KTG_TBL WHERE KTG_AD =?";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
			statement.setString(1, ktgname);
			ResultSet row = statement.executeQuery();
			if (row.next()) {
				return true;
			} else
				return false;
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {

				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}
	
}
