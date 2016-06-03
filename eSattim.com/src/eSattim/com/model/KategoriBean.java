package eSattim.com.model;

public class KategoriBean {
	int id;
	String ktgAd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKtgAd() {
		return ktgAd;
	}

	public void setKtgAd(String ktgAd) {
		this.ktgAd = ktgAd;
	}

	public KategoriBean(int id, String ktgAd) {
		super();
		this.id = id;
		this.ktgAd = ktgAd;
	}

	public KategoriBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
