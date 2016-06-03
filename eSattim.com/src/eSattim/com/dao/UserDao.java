package eSattim.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import eSattim.com.model.UserBean;



public class UserDao {

	public static void main(String args[]) {
		System.out.println(userSayisi());
	}

	public List<UserBean> getAllUsers() {
		List<UserBean> users = new ArrayList<UserBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = DriverManager.getConnection(url, kullaniciad, sifre);
			Statement statement = con.createStatement();
			String sorgu = "SELECT * FROM USER_TBL";
			ResultSet rs = statement.executeQuery(sorgu);

			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUSER_ID(rs.getInt("USER_ID"));
				user.setUSER_AD(rs.getString("USER_AD"));
				user.setUSER_SOYAD(rs.getString("USER_SOYAD"));
				user.setUSER_EMAIL(rs.getString("USER_EMAIL"));
				user.setUSER_ROLL(rs.getInt("USER_ROLL"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Veritabanına bağlantı sağlanamadı!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public UserBean getUserById(int userId) {
		UserBean user = new UserBean();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = DriverManager.getConnection(url, kullaniciad, sifre);
			String sorgu = "DELETE FROM USER_TBL WHERE USER_ID=?";
			PreparedStatement ps = con.prepareStatement(sorgu);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user.setUSER_ID(rs.getInt("USER_ID"));
				user.setUSER_AD(rs.getString("USER_AD"));
				user.setUSER_SOYAD(rs.getString("USER_SOYAD"));
				user.setUSER_EMAIL(rs.getString("USER_EMAIL"));
				user.setUSER_ROLL(rs.getInt("USER_ROLL"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Veritabanına bağlantı sağlanamadı!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	public void deleteUser(int userId) {
		UserBean bean = new UserBean();
		bean.setUSER_ID(userId);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "DELETE FROM USER_TBL WHERE USER_ID=?";

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sorgu);
			ps.setInt(1, userId);
			ps.executeUpdate();
			System.out.println("Silme işlemi gerçekleşmiştir.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Veritabanına bağlantı sağlanamadı!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUser(UserBean user) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "UPDATE USER_TBL SET USER_AD=?, USER_SOYAD=?,USER_EMAIL=? WHERE USER_ID=?";
			PreparedStatement ps = con.prepareStatement(sorgu);

			ps.setString(1, user.getUSER_AD());
			ps.setString(2, user.getUSER_SOYAD());
			ps.setString(3, user.getUSER_EMAIL());
			ps.setInt(4, user.getUSER_ID());

			ps.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Veritabanına bağlantı sağlanamadı!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int userSayisi() {
		int sayi=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT COUNT(*) FROM USER_TBL";
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
}
