package entity;

import java.sql.Date;

/**
 * @author mehmet
 */
public class Oyuncu {
    private int id;
    private Takim takim;
    private String isim;
    private Date dogumTarihi;
    private String boy;
    private String mevki;
    private String ayak;
    private int piyasaDegeri;
    private int numara;
    private String uyruk;

    public Oyuncu() {
    }

    public Oyuncu(int id, Takim takim, String isim, Date dogumTarihi, String boy, String mevki, String ayak, int piyasaDegeri, int numara, String uyruk) {
        this.id = id;
        this.takim = takim;
        this.isim = isim;
        this.dogumTarihi = dogumTarihi;
        this.boy = boy;
        this.mevki = mevki;
        this.ayak = ayak;
        this.piyasaDegeri = piyasaDegeri;
        this.numara = numara;
        this.uyruk = uyruk;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Takim getTakim() {
        return takim;
    }

    public void setTakim(Takim takim) {
        this.takim = takim;
    }


    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

    public String getMevki() {
        return mevki;
    }

    public void setMevki(String mevki) {
        this.mevki = mevki;
    }

    public String getAyak() {
        return ayak;
    }

    public void setAyak(String ayak) {
        this.ayak = ayak;
    }

    public int getPiyasaDegeri() {
        return piyasaDegeri;
    }

    public void setPiyasaDegeri(int piyasaDegeri) {
        this.piyasaDegeri = piyasaDegeri;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public String getUyruk() {
        return uyruk;
    }

    public void setUyruk(String uyruk) {
        this.uyruk = uyruk;
    }
    
    
}
