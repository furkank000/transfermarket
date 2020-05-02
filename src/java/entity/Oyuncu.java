package entity;

import java.sql.Date;

/**
 * @author mehmet
 */
public class Oyuncu {
    private int id;
    private int fktakim;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFktakim() {
        return fktakim;
    }

    public void setFktakim(int fktakim) {
        this.fktakim = fktakim;
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