package eSattim.com.model;

import java.sql.Date;

public class RegisterBean {
	private int USER_ID;
	private String USER_AD;
	private String USER_SOYAD;
	private String USER_EMAIL;
	private String USER_PASS;
	private String USER_GSM;
	private Date USER_DATE;
	
	public String getUSER_AD() {
		return USER_AD;
	}
	public void setUSER_AD(String USER_AD) {
		this.USER_AD = USER_AD;
	}
	public String getUSER_SOYAD() {
		return USER_SOYAD;
	}
	public void setUSER_SOYAD(String USER_SOYAD) {
		this.USER_SOYAD = USER_SOYAD;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String USER_EMAIL) {
		this.USER_EMAIL = USER_EMAIL;
	}
	public String getUSER_PASS() {
		return USER_PASS;
	}
	public void setUSER_PASS(String USER_PASS) {
		this.USER_PASS = USER_PASS;
	}
	
	public String getUSER_GSM() {
		return USER_GSM;
	}
	public void setUSER_GSM(String uSER_GSM) {
		USER_GSM = uSER_GSM;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	public Date getUSER_DATE() {
		return USER_DATE;
	}
	public void setUSER_DATE(Date uSER_DATE) {
		USER_DATE = uSER_DATE;
	}
	public RegisterBean(String uSER_AD, String uSER_SOYAD, String uSER_EMAIL, String uSER_PASS) {
		super();
		USER_AD = uSER_AD;
		USER_SOYAD = uSER_SOYAD;
		USER_EMAIL = uSER_EMAIL;
		USER_PASS = uSER_PASS;
	}
	public RegisterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	


}
