package eSattim.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eSattim.com.model.KisilerBean;
import eSattim.com.model.RegisterBean;

public class KisilerDao {
	public static void main(String[] args){
		
	}
	Connection con = null;
	final String OJDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String DB_URL = "jdbc:oracle:thin:@localhost:1521/xe";
	final String User = "onur";
	final String Password = "1234Onur.";

	public List<KisilerBean> Listele(String email) {
		List<KisilerBean> r = new ArrayList<KisilerBean>();
		try {
			Class.forName(OJDBC_DRIVER);
			con = (Connection) DriverManager.getConnection(DB_URL, User, Password);
			String query = "SELECT * FROM USER_TBL WHERE USER_EMAIL=" + "'" + email + "'";
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String ad = rs.getString("USER_AD");
				String soyad = rs.getString("USER_SOYAD");
				String mail = rs.getString("USER_EMAIL");
				int roll = rs.getInt("USER_ROLL");

				KisilerBean kisiler = new KisilerBean(id, ad, soyad, mail, roll);
				r.add(kisiler);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;

	}

	public static int customerDel(int id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "DELETE FROM USER_TBL WHERE USER_ID =?" ;
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
}
