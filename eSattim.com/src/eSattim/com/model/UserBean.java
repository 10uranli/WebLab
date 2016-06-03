package eSattim.com.model;

public class UserBean {
	int USER_ID;
	String USER_AD;
	String USER_SOYAD;
	String USER_EMAIL;
	String USER_PASS;
	String USER_GSM;
	int USER_ROLL;

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_AD() {
		return USER_AD;
	}

	public void setUSER_AD(String uSER_AD) {
		USER_AD = uSER_AD;
	}

	public String getUSER_SOYAD() {
		return USER_SOYAD;
	}

	public void setUSER_SOYAD(String uSER_SOYAD) {
		USER_SOYAD = uSER_SOYAD;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public int getUSER_ROLL() {
		return USER_ROLL;
	}

	public void setUSER_ROLL(int uSER_ROLL) {
		USER_ROLL = uSER_ROLL;
	}

	public String getUSER_PASS() {
		return USER_PASS;
	}

	public void setUSER_PASS(String uSER_PASS) {
		USER_PASS = uSER_PASS;
	}
	
	

	public String getUSER_GSM() {
		return USER_GSM;
	}

	public void setUSER_GSM(String uSER_GSM) {
		USER_GSM = uSER_GSM;
	}

	public UserBean(int uSER_ID, String uSER_AD, String uSER_SOYAD, String uSER_EMAIL, String uSER_PASS,
			String uSER_GSM, int uSER_ROLL) {
		super();
		USER_ID = uSER_ID;
		USER_AD = uSER_AD;
		USER_SOYAD = uSER_SOYAD;
		USER_EMAIL = uSER_EMAIL;
		USER_PASS = uSER_PASS;
		USER_GSM = uSER_GSM;
		USER_ROLL = uSER_ROLL;
	}

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
