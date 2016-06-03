package eSattim.com.model;

public class SiparisBean {
	int SIPARIS_ID;
	int URUN_ID;
	int MUSTERI_ID;
	int TAKSIT_SAY;
	String URUN_AD;
	String MUSTERI_AD;
	String MUSTERI_EMAIL;
	String SIPARIS_DURUM;
	String KARGO_TERCIH;
	String ADRES;
	public int getSIPARIS_ID() {
		return SIPARIS_ID;
	}
	public void setSIPARIS_ID(int sIPARIS_ID) {
		SIPARIS_ID = sIPARIS_ID;
	}
	public int getURUN_ID() {
		return URUN_ID;
	}
	public void setURUN_ID(int uRUN_ID) {
		URUN_ID = uRUN_ID;
	}
	public int getMUSTERI_ID() {
		return MUSTERI_ID;
	}
	public void setMUSTERI_ID(int mUSTERI_ID) {
		MUSTERI_ID = mUSTERI_ID;
	}
	public int getTAKSIT_SAY() {
		return TAKSIT_SAY;
	}
	public void setTAKSIT_SAY(int tAKSIT_SAY) {
		TAKSIT_SAY = tAKSIT_SAY;
	}
	public String getURUN_AD() {
		return URUN_AD;
	}
	public void setURUN_AD(String uRUN_AD) {
		URUN_AD = uRUN_AD;
	}
	public String getMUSTERI_AD() {
		return MUSTERI_AD;
	}
	public void setMUSTERI_AD(String mUSTERI_AD) {
		MUSTERI_AD = mUSTERI_AD;
	}
	public String getMUSTERI_EMAIL() {
		return MUSTERI_EMAIL;
	}
	public void setMUSTERI_EMAIL(String mUSTERI_EMAIL) {
		MUSTERI_EMAIL = mUSTERI_EMAIL;
	}
	public String getSIPARIS_DURUM() {
		return SIPARIS_DURUM;
	}
	public void setSIPARIS_DURUM(String sIPARIS_DURUM) {
		SIPARIS_DURUM = sIPARIS_DURUM;
	}
	public String getKARGO_TERCIH() {
		return KARGO_TERCIH;
	}
	public void setKARGO_TERCIH(String kARGO_TERCIH) {
		KARGO_TERCIH = kARGO_TERCIH;
	}
	
	public String getADRES() {
		return ADRES;
	}
	public void setADRES(String aDRES) {
		ADRES = aDRES;
	}
	
	public SiparisBean(int sIPARIS_ID, int uRUN_ID, int mUSTERI_ID, int tAKSIT_SAY, String uRUN_AD, String mUSTERI_AD,
			String mUSTERI_EMAIL, String sIPARIS_DURUM, String kARGO_TERCIH, String aDRES) {
		super();
		SIPARIS_ID = sIPARIS_ID;
		URUN_ID = uRUN_ID;
		MUSTERI_ID = mUSTERI_ID;
		TAKSIT_SAY = tAKSIT_SAY;
		URUN_AD = uRUN_AD;
		MUSTERI_AD = mUSTERI_AD;
		MUSTERI_EMAIL = mUSTERI_EMAIL;
		SIPARIS_DURUM = sIPARIS_DURUM;
		KARGO_TERCIH = kARGO_TERCIH;
		ADRES = aDRES;
	}
	public SiparisBean() {
		super();
	}
	
	
}
