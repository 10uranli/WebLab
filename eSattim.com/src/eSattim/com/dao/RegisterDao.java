package eSattim.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import eSattim.com.model.RegisterBean;
import eSattim.com.model.SiparisBean;

public class RegisterDao {
//	public static void main(String[] args) {
//	System.out.println(AllCustomer().get(0).getUSER_AD());	
//	}

	public static void registerUser(String uname, String usurname, String uemail, String upass) {
		RegisterBean bean = new RegisterBean();
		bean.setUSER_AD(uname);
		bean.setUSER_SOYAD(usurname);
		bean.setUSER_EMAIL(uemail);
		bean.setUSER_PASS(upass);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "INSERT INTO USER_TBL (USER_ID,USER_AD ,USER_SOYAD ,USER_EMAIL ,USER_PASS) values (USER_TBL_SEQ.NEXTVAL,?,?,?,?)";

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sorgu);
//			Random r = new Random();
//			int a = r.nextInt(10000);
//			ps.setInt(1, a);
			ps.setString(1, uname);
			ps.setString(2, usurname);
			ps.setString(3, uemail);
			ps.setString(4, upass);
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

	public static boolean kullaniciVarmi(String username, String password) {
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
			String query = "SELECT USER_EMAIL,USER_PASS FROM USER_TBL WHERE USER_EMAIL=? AND USER_PASS=?";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
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

	public static boolean userControl(String email) {
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
			String query = "SELECT USER_EMAIL,USER_ROLL FROM USER_TBL WHERE USER_EMAIL='" + email + "' AND USER_ROLL='"
					+ 1 + "'";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
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

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

	public static String getUserName(String email) {
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
			String query = "SELECT USER_AD FROM USER_TBL WHERE USER_EMAIL= ?";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setString(1, email);
			ResultSet row = statement.executeQuery();
			if (row.next()) {
				ad = row.getString(1);
			} else
				ad = "bos";
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

	public static String getUserSurname(String email) {
		String soyad = "";
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
			String query = "SELECT USER_SOYAD FROM USER_TBL WHERE USER_EMAIL= ?";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setString(1, email);
			ResultSet row = statement.executeQuery();
			if (row.next()) {
				soyad = row.getString(1);
			} else
				soyad = "bos";
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
		return soyad;
	}

	public static String getUserPass(String email) {
		String pass = "";
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
			String query = "SELECT USER_PASS FROM USER_TBL WHERE USER_EMAIL= ?";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setString(1, email);
			ResultSet row = statement.executeQuery();
			if (row.next()) {
				pass = row.getString(1);
			} else
				pass = "bos";
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
		return pass;
	}

	public static String getUserGsm(String email) {
		String gsm = "";
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
			String query = "SELECT USER_GSM FROM USER_TBL WHERE USER_EMAIL= ?";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setString(1, email);
			ResultSet row = statement.executeQuery();
			if (row.next()) {
				gsm = row.getString(1);
			} else
				gsm = "bos";
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
		return gsm;
	}

	public static int getUserId(String email) {
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
			String query = "SELECT USER_ID FROM USER_TBL WHERE USER_EMAIL= ?";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setString(1, email);
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

	public static int updateUser(String ad, String soyad, String email, String sifre, String gsm, int id) {
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
			String query = "UPDATE USER_TBL SET USER_AD=?, USER_SOYAD=?, USER_EMAIL=?, USER_PASS=?, USER_GSM=? WHERE USER_ID=?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, ad);
			stm.setString(2, soyad);
			stm.setString(3, email);
			stm.setString(4, sifre);
			stm.setString(5, gsm);
			stm.setInt(6, id);

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

	public static int rollGuncelle(int id) {
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
			String query = "UPDATE USER_TBL SET USER_ROLL=1 WHERE USER_ID=?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setInt(1, id);
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
	public static int adminCikar(int id) {
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
			String query = "UPDATE USER_TBL SET USER_ROLL=2 WHERE USER_ID=?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setInt(1, id);
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
	public static ArrayList<RegisterBean> AllCustomer(){
		ArrayList<RegisterBean> uye = new ArrayList<RegisterBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM USER_TBL";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				RegisterBean rg = new RegisterBean();
				rg.setUSER_ID(rs.getInt("USER_ID"));
				rg.setUSER_EMAIL(rs.getString("USER_EMAIL"));
				rg.setUSER_PASS(rs.getString("USER_PASS"));
				rg.setUSER_AD(rs.getString("USER_AD"));
				rg.setUSER_SOYAD(rs.getString("USER_SOYAD"));
				rg.setUSER_GSM(rs.getString("USER_GSM"));
				uye.add(rg);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return uye;
	}
	public static ArrayList<RegisterBean> adminGetir() {
		ArrayList<RegisterBean> uye = new ArrayList<RegisterBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String kullaniciad = "onur";
			String sifre = "1234Onur.";
			Connection con = null;
			con = DriverManager.getConnection(url, kullaniciad, sifre);

			String sorgu = "SELECT * FROM USER_TBL WHERE USER_ROLL=1";
			PreparedStatement psmt = con.prepareStatement(sorgu);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				RegisterBean rg = new RegisterBean();
				rg.setUSER_ID(rs.getInt("USER_ID"));
				rg.setUSER_EMAIL(rs.getString("USER_EMAIL"));
				rg.setUSER_PASS(rs.getString("USER_PASS"));
				rg.setUSER_AD(rs.getString("USER_AD"));
				rg.setUSER_SOYAD(rs.getString("USER_SOYAD"));
				rg.setUSER_GSM(rs.getString("USER_GSM"));
				uye.add(rg);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return uye;
	}
	public static boolean emailKontrol(String username) {
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
			String query = "SELECT USER_EMAIL FROM USER_TBL WHERE USER_EMAIL=?";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
			statement.setString(1, username);
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
