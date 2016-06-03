package eSattim.com.model;

public class UrunBean {
	int ktgid;
	int urunid;
	int urunfiyat;
	String urunad;
	String uaciklama;
	String uanahtar;
	String ktgAd;

	public int getKtgid() {
		return ktgid;
	}

	public void setKtgid(int ktgid) {
		this.ktgid = ktgid;
	}

	public int getUrunid() {
		return urunid;
	}

	public void setUrunid(int urunid) {
		this.urunid = urunid;
	}

	public int getUrunfiyat() {
		return urunfiyat;
	}

	public void setUrunfiyat(int urunfiyat) {
		this.urunfiyat = urunfiyat;
	}

	public String getUrunad() {
		return urunad;
	}

	public void setUrunad(String urunad) {
		this.urunad = urunad;
	}

	public String getUaciklama() {
		return uaciklama;
	}

	public void setUaciklama(String uaciklama) {
		this.uaciklama = uaciklama;
	}

	public String getUanahtar() {
		return uanahtar;
	}

	public void setUanahtar(String uanahtar) {
		this.uanahtar = uanahtar;
	}

	public UrunBean(int ktgid, int urunid, int urunfiyat, String urunad, String uaciklama, String uanahtar) {
		super();
		this.ktgid = ktgid;
		this.urunid = urunid;
		this.urunfiyat = urunfiyat;
		this.urunad = urunad;
		this.uaciklama = uaciklama;
		this.uanahtar = uanahtar;
	}

	public UrunBean() {
		super();
	}

	public String getKtgAd() {
		return ktgAd;
	}

	public void setKtgAd(String ktgAd) {
		this.ktgAd = ktgAd;
	}

}
