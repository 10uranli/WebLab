package eSattim.com.model;

public class KisilerBean {
	int id;
	String isim;
	String soyisim;
	String email;
	int roll;
	
	public KisilerBean(int id, String isim, String soyisim, String email, int roll) {
		super();
		this.id = id;
		this.isim = isim;
		this.soyisim = soyisim;
		this.email = email;
		this.roll = roll;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getSoyisim() {
		return soyisim;
	}
	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	public String toString() {
		 
		 return id+" "+isim+" "+soyisim+" "+email+" "+roll;
	}

	
	
	
	
	
}
